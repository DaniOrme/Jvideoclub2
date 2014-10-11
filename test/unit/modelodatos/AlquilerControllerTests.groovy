package modelodatos



import org.junit.*
import grails.test.mixin.*

@TestFor(AlquilerController)
@Mock(Alquiler)
class AlquilerControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/alquiler/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.alquilerInstanceList.size() == 0
        assert model.alquilerInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.alquilerInstance != null
    }

    void testSave() {
        controller.save()

        assert model.alquilerInstance != null
        assert view == '/alquiler/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/alquiler/show/1'
        assert controller.flash.message != null
        assert Alquiler.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/alquiler/list'


        populateValidParams(params)
        def alquiler = new Alquiler(params)

        assert alquiler.save() != null

        params.id = alquiler.id

        def model = controller.show()

        assert model.alquilerInstance == alquiler
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/alquiler/list'


        populateValidParams(params)
        def alquiler = new Alquiler(params)

        assert alquiler.save() != null

        params.id = alquiler.id

        def model = controller.edit()

        assert model.alquilerInstance == alquiler
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/alquiler/list'

        response.reset()


        populateValidParams(params)
        def alquiler = new Alquiler(params)

        assert alquiler.save() != null

        // test invalid parameters in update
        params.id = alquiler.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/alquiler/edit"
        assert model.alquilerInstance != null

        alquiler.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/alquiler/show/$alquiler.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        alquiler.clearErrors()

        populateValidParams(params)
        params.id = alquiler.id
        params.version = -1
        controller.update()

        assert view == "/alquiler/edit"
        assert model.alquilerInstance != null
        assert model.alquilerInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/alquiler/list'

        response.reset()

        populateValidParams(params)
        def alquiler = new Alquiler(params)

        assert alquiler.save() != null
        assert Alquiler.count() == 1

        params.id = alquiler.id

        controller.delete()

        assert Alquiler.count() == 0
        assert Alquiler.get(alquiler.id) == null
        assert response.redirectedUrl == '/alquiler/list'
    }
}

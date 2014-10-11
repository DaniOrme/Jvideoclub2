package modelodatos



import org.junit.*
import grails.test.mixin.*

@TestFor(SoporteController)
@Mock(Soporte)
class SoporteControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/soporte/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.soporteInstanceList.size() == 0
        assert model.soporteInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.soporteInstance != null
    }

    void testSave() {
        controller.save()

        assert model.soporteInstance != null
        assert view == '/soporte/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/soporte/show/1'
        assert controller.flash.message != null
        assert Soporte.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/soporte/list'


        populateValidParams(params)
        def soporte = new Soporte(params)

        assert soporte.save() != null

        params.id = soporte.id

        def model = controller.show()

        assert model.soporteInstance == soporte
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/soporte/list'


        populateValidParams(params)
        def soporte = new Soporte(params)

        assert soporte.save() != null

        params.id = soporte.id

        def model = controller.edit()

        assert model.soporteInstance == soporte
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/soporte/list'

        response.reset()


        populateValidParams(params)
        def soporte = new Soporte(params)

        assert soporte.save() != null

        // test invalid parameters in update
        params.id = soporte.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/soporte/edit"
        assert model.soporteInstance != null

        soporte.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/soporte/show/$soporte.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        soporte.clearErrors()

        populateValidParams(params)
        params.id = soporte.id
        params.version = -1
        controller.update()

        assert view == "/soporte/edit"
        assert model.soporteInstance != null
        assert model.soporteInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/soporte/list'

        response.reset()

        populateValidParams(params)
        def soporte = new Soporte(params)

        assert soporte.save() != null
        assert Soporte.count() == 1

        params.id = soporte.id

        controller.delete()

        assert Soporte.count() == 0
        assert Soporte.get(soporte.id) == null
        assert response.redirectedUrl == '/soporte/list'
    }
}

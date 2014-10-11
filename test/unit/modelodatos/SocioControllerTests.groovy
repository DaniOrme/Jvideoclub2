package modelodatos



import org.junit.*
import grails.test.mixin.*

@TestFor(SocioController)
@Mock(Socio)
class SocioControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/socio/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.socioInstanceList.size() == 0
        assert model.socioInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.socioInstance != null
    }

    void testSave() {
        controller.save()

        assert model.socioInstance != null
        assert view == '/socio/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/socio/show/1'
        assert controller.flash.message != null
        assert Socio.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/socio/list'


        populateValidParams(params)
        def socio = new Socio(params)

        assert socio.save() != null

        params.id = socio.id

        def model = controller.show()

        assert model.socioInstance == socio
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/socio/list'


        populateValidParams(params)
        def socio = new Socio(params)

        assert socio.save() != null

        params.id = socio.id

        def model = controller.edit()

        assert model.socioInstance == socio
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/socio/list'

        response.reset()


        populateValidParams(params)
        def socio = new Socio(params)

        assert socio.save() != null

        // test invalid parameters in update
        params.id = socio.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/socio/edit"
        assert model.socioInstance != null

        socio.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/socio/show/$socio.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        socio.clearErrors()

        populateValidParams(params)
        params.id = socio.id
        params.version = -1
        controller.update()

        assert view == "/socio/edit"
        assert model.socioInstance != null
        assert model.socioInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/socio/list'

        response.reset()

        populateValidParams(params)
        def socio = new Socio(params)

        assert socio.save() != null
        assert Socio.count() == 1

        params.id = socio.id

        controller.delete()

        assert Socio.count() == 0
        assert Socio.get(socio.id) == null
        assert response.redirectedUrl == '/socio/list'
    }
}

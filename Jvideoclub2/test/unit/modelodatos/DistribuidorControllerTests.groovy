package modelodatos



import org.junit.*
import grails.test.mixin.*

@TestFor(DistribuidorController)
@Mock(Distribuidor)
class DistribuidorControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/distribuidor/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.distribuidorInstanceList.size() == 0
        assert model.distribuidorInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.distribuidorInstance != null
    }

    void testSave() {
        controller.save()

        assert model.distribuidorInstance != null
        assert view == '/distribuidor/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/distribuidor/show/1'
        assert controller.flash.message != null
        assert Distribuidor.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/distribuidor/list'


        populateValidParams(params)
        def distribuidor = new Distribuidor(params)

        assert distribuidor.save() != null

        params.id = distribuidor.id

        def model = controller.show()

        assert model.distribuidorInstance == distribuidor
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/distribuidor/list'


        populateValidParams(params)
        def distribuidor = new Distribuidor(params)

        assert distribuidor.save() != null

        params.id = distribuidor.id

        def model = controller.edit()

        assert model.distribuidorInstance == distribuidor
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/distribuidor/list'

        response.reset()


        populateValidParams(params)
        def distribuidor = new Distribuidor(params)

        assert distribuidor.save() != null

        // test invalid parameters in update
        params.id = distribuidor.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/distribuidor/edit"
        assert model.distribuidorInstance != null

        distribuidor.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/distribuidor/show/$distribuidor.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        distribuidor.clearErrors()

        populateValidParams(params)
        params.id = distribuidor.id
        params.version = -1
        controller.update()

        assert view == "/distribuidor/edit"
        assert model.distribuidorInstance != null
        assert model.distribuidorInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/distribuidor/list'

        response.reset()

        populateValidParams(params)
        def distribuidor = new Distribuidor(params)

        assert distribuidor.save() != null
        assert Distribuidor.count() == 1

        params.id = distribuidor.id

        controller.delete()

        assert Distribuidor.count() == 0
        assert Distribuidor.get(distribuidor.id) == null
        assert response.redirectedUrl == '/distribuidor/list'
    }
}

package modelodatos



import org.junit.*
import grails.test.mixin.*

@TestFor(PeliculaController)
@Mock(Pelicula)
class PeliculaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/pelicula/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.peliculaInstanceList.size() == 0
        assert model.peliculaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.peliculaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.peliculaInstance != null
        assert view == '/pelicula/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/pelicula/show/1'
        assert controller.flash.message != null
        assert Pelicula.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/pelicula/list'


        populateValidParams(params)
        def pelicula = new Pelicula(params)

        assert pelicula.save() != null

        params.id = pelicula.id

        def model = controller.show()

        assert model.peliculaInstance == pelicula
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/pelicula/list'


        populateValidParams(params)
        def pelicula = new Pelicula(params)

        assert pelicula.save() != null

        params.id = pelicula.id

        def model = controller.edit()

        assert model.peliculaInstance == pelicula
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/pelicula/list'

        response.reset()


        populateValidParams(params)
        def pelicula = new Pelicula(params)

        assert pelicula.save() != null

        // test invalid parameters in update
        params.id = pelicula.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/pelicula/edit"
        assert model.peliculaInstance != null

        pelicula.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/pelicula/show/$pelicula.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        pelicula.clearErrors()

        populateValidParams(params)
        params.id = pelicula.id
        params.version = -1
        controller.update()

        assert view == "/pelicula/edit"
        assert model.peliculaInstance != null
        assert model.peliculaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/pelicula/list'

        response.reset()

        populateValidParams(params)
        def pelicula = new Pelicula(params)

        assert pelicula.save() != null
        assert Pelicula.count() == 1

        params.id = pelicula.id

        controller.delete()

        assert Pelicula.count() == 0
        assert Pelicula.get(pelicula.id) == null
        assert response.redirectedUrl == '/pelicula/list'
    }
}

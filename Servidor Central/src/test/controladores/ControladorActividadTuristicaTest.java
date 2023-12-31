package test.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import configuraciones.Cargador;
import excepciones.ActividadTuristicaYaRegistradaException;
import excepciones.CategoriaYaRegistradaException;
import excepciones.CompraConConsumosInsuficientesExcepcion;
import excepciones.CompraPaqueteVencidoExcepcion;
import excepciones.DeparamentoYaRegistradoException;
import excepciones.FechaAltaActividadPosteriorAFechaAltaSalidaException;
import excepciones.FechaAltaSalidaPosteriorAFechaSalidaException;
import excepciones.FechaAltaSalidaTuristicaPosteriorAFechaInscripcion;
import excepciones.InscripcionYaRegistradaException;
import excepciones.NoExisteConsumoParaLaActividadExcepcion;
import excepciones.ObjetoNoExisteEnTurismoUy;
import excepciones.PaqueteNoCompradoExcepcion;
import excepciones.SuperaElMaximoDeTuristasException;
import excepciones.TurismoUyException;
import excepciones.UsuarioYaRegistradoException;
import logica.controladores.Fabrica;
import logica.controladores.IControladorActividadTuristica;
import logica.controladores.IControladorPaquete;
import logica.controladores.IControladorUsuario;
import logica.datatypes.DTActividadTuristica;
import logica.datatypes.DTActividadTuristicaDetalle;
import logica.datatypes.DTProveedorDetallePrivado;
import logica.datatypes.DTSalidaTuristica;
import logica.datatypes.DTSalidaTuristicaDetalle;
import logica.datatypes.DTTuristaDetallePrivado;
import logica.datatypes.EstadoActividadTuristica;
import logica.datatypes.TipoOrdenacion;

class ControladorActividadTuristicaTest {
	private static IControladorActividadTuristica contrActTur;
	private static IControladorUsuario contrUsuario;
	private static IControladorPaquete controladorPaquete;

	private static List<String> muestraCategorias;
	private static LocalDate localDateNow;
	private static LocalDateTime localDateTimeNow;

	@BeforeAll
	static void preparacionPrevia() {
		if (contrActTur == null)
			Cargador.cargarPropiedades();

		contrActTur = Fabrica.getInstancia().getIControladorActividadTuristica();
		contrUsuario = Fabrica.getInstancia().getIControladorUsuario();
		controladorPaquete = Fabrica.getInstancia().getIControladorPaquete();

		muestraCategorias = new ArrayList<String>();
		muestraCategorias.add("EXTREMO");
		muestraCategorias.add("ARTE");
		muestraCategorias.add("TRANQUILO");

		for (var cat : muestraCategorias)
			try {
				contrActTur.altaCategoria(cat);
			} catch (CategoriaYaRegistradaException e) {
				// No pasa nada, es esperado
			}

		localDateNow = LocalDate.now();
		localDateTimeNow = LocalDateTime.now();
	}

	// No es un test en sí
	static List<String> generarActividades(int cant, String idTest)
			throws ActividadTuristicaYaRegistradaException, ObjetoNoExisteEnTurismoUy {
		preparacionPrevia();
		assertTrue(contrActTur != null);

		List<String> nombresActividades = new ArrayList<>();

		for (int i = 0; i < cant; i++) {
			String nickProveedor = "Proveedor " + idTest + " i=" + i;
			String departamento = "Departamento " + idTest + " i=" + i;
			String nombreActividad = "Actividad " + idTest + " i=" + i;
			String descripcion = "Desc";
			int duracion = 10;
			float costo = (float) 10.85;
			String ciudad = "Ciudad";
			LocalDate fechaAlta = localDateNow;

			contrActTur.altaActividadTuristica(nickProveedor, departamento, nombreActividad, descripcion, duracion,
					costo, ciudad, fechaAlta, null, muestraCategorias, null);

			nombresActividades.add(nombreActividad);
		}
		return nombresActividades;
	}

	// No es un test en sí
	static void aceptarActividades(List<String> acts) throws TurismoUyException {
		preparacionPrevia();
		assertTrue(contrActTur != null);

		for (String a : acts) {
			contrActTur.cambiarEstadoDeActividadTuristica(a, EstadoActividadTuristica.ACEPTADA);
		}
	}

	// No es un test en sí
	static List<String> generarSalidas(int cant, String idTest) throws TurismoUyException {
		preparacionPrevia();
		assertTrue(contrActTur != null);

		List<String> nombresSalidas = new ArrayList<>();

		for (int i = 0; i < cant; i++) {
			String nombreActividad = "Actividad " + idTest + " i=" + i;
			String nombreSalida = "Salida " + idTest + " i=" + i;
			String ciudad = "Ciudad salida";
			LocalDate fechaAlta = localDateNow;
			LocalDateTime fechaYHoraSalida = localDateTimeNow.plusDays(40);
			int cantMaxTur = 50;

			contrActTur.altaSalidaTuristica(nombreActividad, nombreSalida, fechaYHoraSalida, fechaAlta, ciudad,
					cantMaxTur, null);

			nombresSalidas.add(nombreSalida);
		}
		return nombresSalidas;
	}

	// No es un test en sí
	static List<String> generarDepartamentos(int cant, String idTest) throws DeparamentoYaRegistradoException {
		preparacionPrevia();
		assertTrue(contrActTur != null);

		List<String> nombreDepartamentos = new ArrayList<>();

		for (int i = 0; i < cant; i++) {
			String nom = "Departamento " + idTest + " i=" + i;
			String descr = "Descripcion";
			String url = "https://www.canelones-departamento.org.uy/inicio.html";

			contrActTur.altaDepartamento(nom, descr, url);
			nombreDepartamentos.add(nom);
		}
		return nombreDepartamentos;
	}

	private List<String> generarCategorias(int cant, String idTest) throws CategoriaYaRegistradaException {
		preparacionPrevia();
		assertTrue(contrActTur != null);
		List<String> nombreCategorias = new ArrayList<>();

		for (int i = 0; i < cant; i++) {
			String nom = "Categoria " + idTest + " i=" + i;
			contrActTur.altaCategoria(nom);
			nombreCategorias.add(nom);
		}
		return nombreCategorias;
	}

	@Test
	public void testAltaDepartamentoOK() throws TurismoUyException {
		generarDepartamentos(100, "testAltaDepartamentoOK");
	}

	@Test
	public void testAltaDepartamentoRepetido() throws TurismoUyException {
		assertTrue(contrActTur != null);

		generarDepartamentos(1, "testAltaDepartamentoRepetido");

		// Repito y debería tirar la excepcion
		assertThrows(DeparamentoYaRegistradoException.class, () -> {
			generarDepartamentos(1, "testAltaDepartamentoRepetido");
		});
	}

	@Test
	public void testObtenerIdDepartamentos() throws TurismoUyException {
		assertTrue(contrActTur != null);

		for (int i = 0; i < 100; i++) {
			String nom = "Dep testObtenerIdDepartamentos" + i;
			String descr = "Descripcion";
			String url = "https://www.canelones-departamento.org.uy/inicio.html";

			contrActTur.altaDepartamento(nom, descr, url);

			List<String> idsLoop = contrActTur.obtenerIdDepartamentos();

			// Ambos departamentos deberían estar una única vez
			assertTrue(idsLoop.remove(nom));

			assertFalse(idsLoop.remove(nom));
		}

		var ids = contrActTur.obtenerIdDepartamentos();
		for (int i = 0; i < 100; i++) {
			String nom = "Dep testObtenerIdDepartamentos" + i;
			// Los paquetes deberían estar una única vez
			assertTrue(ids.remove(nom));
			assertFalse(ids.remove(nom));
		}
	}

	@Test
	public void testAltaActividadTuristicaOK() throws TurismoUyException {
		assertTrue(contrActTur != null);

		for (int i = 0; i < 100; i++) {

			String nombreProveedor = "Proveedor testAltaActividadTuristicaOK i=" + (i % 10);
			String departamento = "Departamento testAltaActividadTuristicaOK i=" + (i % 10);
			String nombreActividad = "Actividad testAltaActividadTuristicaOK i=" + i;
			String descripcion = "Desc";
			int duracion = 10;
			float costo = (float) 10;
			String ciudad = "Ciudad";
			LocalDate fechaAlta = localDateNow;

			try {
				contrActTur.altaDepartamento(departamento, descripcion, departamento);
			} catch (DeparamentoYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}

			try {
				Fabrica.getInstancia().getIControladorUsuario().altaProveedor(nombreProveedor, nombreProveedor,
						nombreProveedor, nombreProveedor, nombreProveedor, fechaAlta, null, nombreProveedor,
						nombreProveedor);
			} catch (UsuarioYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}

			contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion, duracion,
					costo, ciudad, fechaAlta, null, muestraCategorias, null);

			// assertTrue(cat.existeActividadTuristica(nombreActividad));
			assertTrue(contrActTur.obtenerIdActividadesTuristicas(departamento).contains(nombreActividad));

			DTActividadTuristicaDetalle act = contrActTur.obtenerDTActividadTuristicaDetalle(nombreActividad);
			assertTrue(act != null);

			assertEquals(nombreActividad, act.getNombre());
			assertEquals(descripcion, act.getDescripcion());
			assertEquals(duracion, act.getDuracion());
			assertEquals(costo, act.getCostoPorTurista());
			assertEquals(ciudad, act.getCuidad());
			assertEquals(fechaAlta, act.getFechaAlta());

			assertTrue(act.getPaquetes().isEmpty());
			assertTrue(act.getSalidas().isEmpty());
		}
	}

	@Test
	public void testAltaActividadTuristicaSinFecha() throws TurismoUyException {
		assertTrue(contrActTur != null);

		for (int i = 0; i < 100; i++) {

			String nombreProveedor = "Proveedor testAltaActividadTuristicaSinFecha i=" + (i % 10);
			String departamento = "Departamento testAltaActividadTuristicaSinFecha i=" + (i % 10);
			String nombreActividad = "Actividad testAltaActividadTuristicaSinFecha i=" + i;
			String descripcion = "Desc";
			int duracion = 10;
			float costo = (float) 10;
			String ciudad = "Ciudad";

			try {
				contrActTur.altaDepartamento(departamento, descripcion, departamento);
			} catch (DeparamentoYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}

			try {
				Fabrica.getInstancia().getIControladorUsuario().altaProveedor(nombreProveedor, nombreProveedor,
						nombreProveedor, nombreProveedor, nombreProveedor, null, null, nombreProveedor,
						nombreProveedor);
			} catch (UsuarioYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}

			contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion, duracion,
					costo, ciudad, null, null, muestraCategorias, null);

			// assertTrue(cat.existeActividadTuristica(nombreActividad));
			assertTrue(contrActTur.obtenerIdActividadesTuristicas(departamento).contains(nombreActividad));

			DTActividadTuristicaDetalle act = contrActTur.obtenerDTActividadTuristicaDetalle(nombreActividad);
			assertTrue(act != null);

			assertEquals(nombreActividad, act.getNombre());
			assertEquals(descripcion, act.getDescripcion());
			assertEquals(duracion, act.getDuracion());
			assertEquals(costo, act.getCostoPorTurista());
			assertEquals(ciudad, act.getCuidad());
			assertNotEquals(null, act.getFechaAlta());

			assertTrue(act.getPaquetes().isEmpty());
			assertTrue(act.getSalidas().isEmpty());
		}
	}

	@Test
	public void testAltaActividadTuristicaRepetida() throws TurismoUyException {
		assertTrue(contrActTur != null);

		for (int i = 0; i < 100; i++) {

			String nombreProveedor = "Proveedor testAltaActividadTuristicaRepetida i=" + (i % 10);
			String departamento = "Departamento testAltaActividadTuristicaRepetida i=" + (i % 10);
			String nombreActividad = "Actividad testAltaActividadTuristicaRepetida i=" + i;
			String descripcion = "Desc";
			int duracion = 10;
			float costo = (float) 10;
			String ciudad = "Ciudad";
			LocalDate fechaAlta = localDateNow;

			try {
				contrActTur.altaDepartamento(departamento, descripcion, departamento);
			} catch (DeparamentoYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}

			try {
				Fabrica.getInstancia().getIControladorUsuario().altaProveedor(nombreProveedor, nombreProveedor,
						nombreProveedor, nombreProveedor, nombreProveedor, fechaAlta, null, nombreProveedor,
						nombreProveedor);
			} catch (UsuarioYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}

			contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion, duracion,
					costo, ciudad, fechaAlta, null, muestraCategorias, null);

			// Repito y debería tirar la excepcion
			assertThrows(ActividadTuristicaYaRegistradaException.class, () -> {
				contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion,
						duracion, costo, ciudad, fechaAlta, null, muestraCategorias, null);
			});

			// assertTrue(cat.existeActividadTuristica(nombreActividad));
			assertTrue(contrActTur.obtenerIdActividadesTuristicas(departamento).contains(nombreActividad));

			DTActividadTuristicaDetalle act = contrActTur.obtenerDTActividadTuristicaDetalle(nombreActividad);
			assertTrue(act != null);

			assertEquals(nombreActividad, act.getNombre());
			assertEquals(descripcion, act.getDescripcion());
			assertEquals(duracion, act.getDuracion());
			assertEquals(costo, act.getCostoPorTurista());
			assertEquals(ciudad, act.getCuidad());
			assertEquals(fechaAlta, act.getFechaAlta());

			assertTrue(act.getPaquetes().isEmpty());
			assertTrue(act.getSalidas().isEmpty());
		}
	}

	@Test
	public void testObtenerIdActividadesTuristicas() throws TurismoUyException {
		assertTrue(contrActTur != null);

		for (int i = 0; i < 100; i++) {
			String nombreProveedor = "Proveedor testObtenerIdActividadesTuristicas i=" + (i % 10);
			String departamento = "Departamento testObtenerIdActividadesTuristicas i=" + (i % 10);
			String nombreActividad = "Actividad testObtenerIdActividadesTuristicas i=" + i;
			String descripcion = "Desc";
			int duracion = 10;
			float costo = (float) 10;
			String ciudad = "Ciudad";
			LocalDate fechaAlta = localDateNow;

			try {
				contrActTur.altaDepartamento(departamento, descripcion, departamento);
			} catch (DeparamentoYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}

			try {
				Fabrica.getInstancia().getIControladorUsuario().altaProveedor(nombreProveedor, nombreProveedor,
						nombreProveedor, nombreProveedor, nombreProveedor, fechaAlta, null, nombreProveedor,
						nombreProveedor);
			} catch (UsuarioYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}

			contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion, duracion,
					costo, ciudad, fechaAlta, null, muestraCategorias, null);

			var ids_loop = contrActTur.obtenerIdActividadesTuristicas(departamento);

			// Ambos departamentos deberían estar una única vez
			assertTrue(ids_loop.remove(nombreActividad));

			assertFalse(ids_loop.remove(nombreActividad));
		}
	}

	@Test
	public void testObtenerIdSalidasTuristicas() throws TurismoUyException {
		assertTrue(contrActTur != null);

		String idTest = "testObtenerIdSalidasTuristicas";

		ControladorUsuarioTest.generarProveedores(50, idTest);
		generarDepartamentos(50, idTest);
		aceptarActividades(ControladorActividadTuristicaTest.generarActividades(50, idTest));
		generarSalidas(50, idTest);

		for (int j = 0; j < 50; j++) {
			String nombreActividad = "Actividad " + idTest + " i=" + j;
			String nombreSalida = "Salida " + idTest + " i=" + j;
			var salidas = contrActTur.obtenerIdSalidasTuristicas(nombreActividad);

			assertEquals(1, salidas.size());
			assertEquals(nombreSalida, salidas.get(0));
		}
	}

	@Test
	public void testObtenerDetallesActividadTuristica() throws TurismoUyException {
		assertTrue(contrActTur != null);
		String descripcion = "Desc";

		// paquetes:
		String nombre = "Paquete";
		int periodovalidez = 15;
		float descuento = (float) 1;
		controladorPaquete.altaPaquete(nombre, descripcion, periodovalidez, descuento, LocalDate.of(2022, 1, 1), null);

		for (int i = 0; i < 100; i++) {
			String nombreProveedor = "Proveedor testObtenerDetallesActividadTuristica i=" + (i % 10);
			String departamento = "Departamento testObtenerDetallesActividadTuristica i=" + (i % 10);
			String nombreActividad = "Actividad testObtenerDetallesActividadTuristica i=" + i;
			String nombreSalida = "Salida testObtenerDetallesActividadTuristica i=" + i;
			int duracion = 10;
			float costo = (float) 10;
			String ciudad = "Ciudad";
			LocalDate fechaAlta = localDateNow;
			LocalDateTime fechaConHoraAhora = localDateTimeNow;

			try {
				contrActTur.altaDepartamento(departamento, descripcion, departamento);
			} catch (DeparamentoYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}

			try {
				contrUsuario.altaProveedor(nombreProveedor, nombreProveedor, nombreProveedor, nombreProveedor,
						nombreProveedor, fechaAlta, null, nombreProveedor, nombreProveedor);
			} catch (UsuarioYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}

			contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion, duracion,
					costo, ciudad, fechaAlta, null, muestraCategorias, null);
			contrActTur.cambiarEstadoDeActividadTuristica(nombreActividad, EstadoActividadTuristica.ACEPTADA);
			if (i % 2 == 0) {
				contrActTur.altaSalidaTuristica(nombreActividad, nombreSalida, fechaConHoraAhora.plusYears(7),
						fechaAlta.plusYears(6), "lugar", 5, null);
			}

			controladorPaquete.agregarActividadAPaquete(nombreActividad, "Paquete");

			DTActividadTuristicaDetalle act = contrActTur.obtenerDTActividadTuristicaDetalle(nombreActividad);
			assertTrue(act != null);

			assertEquals(nombreActividad, act.getNombre());
			assertEquals(descripcion, act.getDescripcion());
			assertEquals(duracion, act.getDuracion());
			assertEquals(costo, act.getCostoPorTurista());
			assertEquals(ciudad, act.getCuidad());
			assertEquals(fechaAlta, act.getFechaAlta());
			assertFalse(act.getPaquetes().isEmpty());

			if (i % 2 == 0) {
				assertNotEquals(0, act.getSalidas().size());

				DTSalidaTuristica salida = act.getSalida(nombreSalida);

				assertNotEquals(null, salida);

				assertEquals(nombreSalida, salida.getNombre());
				assertEquals(5, salida.getCantMaxTuristas());
				assertEquals(fechaAlta.plusYears(6), salida.getFechaAlta());
			} else {
				assertTrue(act.getSalidas().isEmpty());
			}
			assertTrue(act.getPaquetes().containsKey("Paquete"));

		}
	}

	@Test
	public void testObtenerDTSalidasTuristicas() throws TurismoUyException {
		String idTest = "testObtenerDTSalidasTuristicas";

		ControladorUsuarioTest.generarProveedores(100, idTest);
		ControladorActividadTuristicaTest.generarDepartamentos(100, idTest);
		aceptarActividades(generarActividades(100, idTest));

		generarSalidas(100, idTest);

		for (int i = 0; i < 100; i++) {
			String nombreActividad = "Actividad " + idTest + " i=" + i;
			String nombreSalida = "Salida " + idTest + " i=" + i;
			String ciudad = "Ciudad salida";
			LocalDate fechaAlta = localDateNow;
			LocalDateTime fechaYHoraSalida = localDateTimeNow.plusDays(40);
			int cantMaxTur = 50;

			var salidas = contrActTur.obtenerDTSalidasTuristicas(nombreActividad);

			assertEquals(1, salidas.size());

			for (var sal : salidas) {
				assertEquals(nombreSalida, sal.getNombre());
				assertEquals(ciudad, sal.getLugarSalida());
				assertEquals(fechaAlta, sal.getFechaAlta());
				assertEquals(cantMaxTur, sal.getCantMaxTuristas());
			}
		}
	}

	@Test
	public void testAltaInscripcionSalidaTuristicaOK() throws TurismoUyException {
		String nicknameTurista = "Turista ";
		String nombre = "NOMBRE TURISTA";
		String apellido = "APELLIDO TURISTA";
		String correo = "TURISTA ";
		String nacionalidad = "CHINA";
		LocalDate fNacimiento = localDateNow.minusDays(30);
		contrUsuario.altaTurista(nicknameTurista, nombre, apellido, correo, "1234", fNacimiento, null, nacionalidad);

		String nombreProveedor = "prov";
		String departamento = "deptoTest";
		String nombreActividad = "actividad";
		String descripcion = "Desc";
		int duracion = 10;
		float costo = (float) 10;
		String ciudad = "Ciudad";
		LocalDate fechaAlta = localDateNow.minusDays(30);

		String nombreSalida = "salida";
		LocalDateTime fechaHoraSalida = localDateTimeNow.plusDays(2);
		LocalDate fechaAltaSalida = localDateNow.minusDays(10);
		;
		String lugar = "lugar";
		int cantMaxTuristas = 10;

		contrActTur.altaDepartamento(departamento, descripcion, departamento);

		contrUsuario.altaProveedor(nombreProveedor, nombreProveedor, nombreProveedor, nombreProveedor, nombreProveedor,
				fechaAlta, null, nombreProveedor, nombreProveedor);

		contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion, duracion, costo,
				ciudad, fechaAlta, null, muestraCategorias, null);
		contrActTur.cambiarEstadoDeActividadTuristica(nombreActividad, EstadoActividadTuristica.ACEPTADA);
		contrActTur.altaSalidaTuristica(nombreActividad, nombreSalida, fechaHoraSalida, fechaAltaSalida, lugar,
				cantMaxTuristas, null);

		contrActTur.altaInscripcionSalidaTuristica(nombreSalida, nicknameTurista, 1, null, null);

		assertEquals(contrActTur.obtenerDTInscripcion(nicknameTurista, nombreSalida).getFechaInscripcion(),
				localDateNow);
		assertEquals(contrActTur.obtenerDTInscripcion(nicknameTurista, nombreSalida).getCantidadTuristas(), 1);
		assertEquals(contrActTur.obtenerDTInscripcion(nicknameTurista, nombreSalida).getTurista(), nicknameTurista);
		assertEquals(contrActTur.obtenerDTInscripcion(nicknameTurista, nombreSalida).getSalidaTuristica().getNombre(),
				nombreSalida);
		assertEquals(contrActTur.obtenerDTInscripcion(nicknameTurista, nombreSalida).getCosto(), costo);

		nombreSalida = "salida2";
		fechaHoraSalida = localDateTimeNow.plusDays(2);
		fechaAltaSalida = localDateNow.minusDays(10);
		lugar = "lugar";
		cantMaxTuristas = 10;

		contrActTur.altaSalidaTuristica(nombreActividad, nombreSalida, fechaHoraSalida, fechaAltaSalida, lugar,
				cantMaxTuristas, null);

		String nombrePaquete = "nomPaquete-altaInscrpiconOK";
		String descripcionPaquete = "desc";
		int periodoValides = 2;
		float descuento = (float) 50.0;
		LocalDate fechaAltaPaquete = localDateNow.minusDays(20);

		controladorPaquete.altaPaquete(nombrePaquete, descripcionPaquete, periodoValides, descuento, fechaAltaPaquete,
				null);

		controladorPaquete.agregarActividadAPaquete(nombreActividad, nombrePaquete);

		controladorPaquete.comprarPaquete(nicknameTurista, nombrePaquete, 1, null);

		contrActTur.altaInscripcionSalidaTuristica(nombreSalida, nicknameTurista, 1, localDateNow, nombrePaquete);
	}

	@Test
	public void testAltaInscripcionSalidaTuristicaRepetida() throws TurismoUyException {

		String nickname = "testAltaInscripcionSalidaTuristicaRepetida Turista nickname";
		String nombre = "testAltaInscripcionSalidaTuristicaRepetida NOMBRE TURISTA";
		String apellido = "testAltaInscripcionSalidaTuristicaRepetida APELLIDO TURISTA";
		String correo = "testAltaInscripcionSalidaTuristicaRepetida TURISTA correo";
		String nacionalidad = "CHINA";
		LocalDate fNacimiento = localDateNow;

		String nombreProveedor = "testAltaInscripcionSalidaTuristicaRepetida prov";
		String departamento = "testAltaInscripcionSalidaTuristicaRepetida deptoTest";
		String nombreActividad = "testAltaInscripcionSalidaTuristicaRepetida actividad";
		String descripcion = "testAltaInscripcionSalidaTuristicaRepetida Desc";
		int duracion = 10;
		float costo = (float) 10;
		String ciudad = "Ciudad";
		LocalDate fechaAlta = localDateNow;
		String nombreSalida = "testAltaInscripcionSalidaTuristicaRepetida salida";
		LocalDate fecha = localDateNow;
		LocalDateTime fechaHoraSalida = localDateTimeNow.plusMonths(1);
		LocalDate fechaAltaSalida = fecha;
		String lugar = "lugar";
		int cantMaxTuristas = 10;

		contrUsuario.altaTurista(nickname, nombre, apellido, correo, "1234", fNacimiento, null, nacionalidad);
		contrActTur.altaDepartamento(departamento, descripcion, departamento);
		contrUsuario.altaProveedor(nombreProveedor, nombreProveedor, nombreProveedor, nombreProveedor, nombreProveedor,
				fechaAlta, null, nombreProveedor, nombreProveedor);
		contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion, duracion, costo,
				ciudad, fechaAlta, null, muestraCategorias, null);
		contrActTur.cambiarEstadoDeActividadTuristica(nombreActividad, EstadoActividadTuristica.ACEPTADA);
		contrActTur.altaSalidaTuristica(nombreActividad, nombreSalida, fechaHoraSalida, fechaAltaSalida, lugar,
				cantMaxTuristas, null);

		contrActTur.altaInscripcionSalidaTuristica(nombreSalida, nickname, 1, localDateNow, null);

		assertThrows(InscripcionYaRegistradaException.class, () -> {
			contrActTur.altaInscripcionSalidaTuristica(nombreSalida, nickname, 2, localDateNow.plusYears(5), null);
		});
	}

	@Test
	public void testAltaInscripcionSalidaTuristicaInscripcionConFechaInscripcionPosteriorAFechaAltaSalida()
			throws TurismoUyException {
		String nickname = "testAltaInscripcionSalidaTuristicaInscripcionConFechaInscripcionPosteriorAFechaAltaSalida Turista nickname";
		String nombre = "testAltaInscripcionSalidaTuristicaInscripcionConFechaInscripcionPosteriorAFechaAltaSalida NOMBRE TURISTA";
		String apellido = "testAltaInscripcionSalidaTuristicaInscripcionConFechaInscripcionPosteriorAFechaAltaSalida APELLIDO TURISTA";
		String correo = "testAltaInscripcionSalidaTuristicaInscripcionConFechaInscripcionPosteriorAFechaAltaSalida TURISTA correo";
		String nacionalidad = "CHINA";
		LocalDate fNacimiento = localDateNow;
		String nombreProveedor = "testAltaInscripcionSalidaTuristicaInscripcionConFechaInscripcionPosteriorAFechaAltaSalida prov";
		String departamento = "testAltaInscripcionSalidaTuristicaInscripcionConFechaInscripcionPosteriorAFechaAltaSalida deptoTest";
		String nombreActividad = "testAltaInscripcionSalidaTuristicaInscripcionConFechaInscripcionPosteriorAFechaAltaSalida actividad";
		String descripcion = "testAltaInscripcionSalidaTuristicaInscripcionConFechaInscripcionPosteriorAFechaAltaSalida Desc";
		int duracion = 10;
		float costo = (float) 10;
		String ciudad = "Ciudad";
		String nombreSalida = "testAltaInscripcionSalidaTuristicaInscripcionConFechaInscripcionPosteriorAFechaAltaSalida salida";
		String lugar = "lugar";
		int cantMaxTuristas = 3;

		contrUsuario.altaTurista(nickname, nombre, apellido, correo, "1234", fNacimiento, null, nacionalidad);
		contrActTur.altaDepartamento(departamento, descripcion, departamento);
		contrUsuario.altaProveedor(nombreProveedor, nombreProveedor, nombreProveedor, nombreProveedor, nombreProveedor,
				localDateNow, null, nombreProveedor, nombreProveedor);
		contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion, duracion, costo,
				ciudad, localDateNow, null, muestraCategorias, null);
		contrActTur.cambiarEstadoDeActividadTuristica(nombreActividad, EstadoActividadTuristica.ACEPTADA);
		contrActTur.altaSalidaTuristica(nombreActividad, nombreSalida, localDateTimeNow, localDateNow, lugar,
				cantMaxTuristas, null);

		assertThrows(FechaAltaSalidaTuristicaPosteriorAFechaInscripcion.class, () -> {
			contrActTur.altaInscripcionSalidaTuristica(nombreSalida, nickname, 2, localDateNow.minusDays(1), null);
		});
	}

	@Test
	public void testAltaInscripcionSalidaTuristicaInscripcionConCapacidadSuperada() throws TurismoUyException {

		String nickname = "testAltaInscripcionSalidaTuristicaInscripcionConCapacidadSuperada Turista nickname";
		String nombre = "testAltaInscripcionSalidaTuristicaInscripcionConCapacidadSuperada NOMBRE TURISTA";
		String apellido = "testAltaInscripcionSalidaTuristicaInscripcionConCapacidadSuperada APELLIDO TURISTA";
		String correo = "testAltaInscripcionSalidaTuristicaInscripcionConCapacidadSuperada TURISTA correo";
		String nacionalidad = "CHINA";
		LocalDate fNacimiento = localDateNow;

		String nombreProveedor = "testAltaInscripcionSalidaTuristicaInscripcionConCapacidadSuperada prov";
		String departamento = "testAltaInscripcionSalidaTuristicaInscripcionConCapacidadSuperada deptoTest";
		String nombreActividad = "testAltaInscripcionSalidaTuristicaInscripcionConCapacidadSuperada actividad";
		String descripcion = "testAltaInscripcionSalidaTuristicaInscripcionConCapacidadSuperada Desc";
		int duracion = 10;
		float costo = (float) 10;
		String ciudad = "Ciudad";
		LocalDate fechaAlta = localDateNow;
		String nombreSalida = "testAltaInscripcionSalidaTuristicaInscripcionConCapacidadSuperada salida";
		LocalDate fecha = localDateNow;
		LocalDateTime fechaHoraSalida = localDateTimeNow.plusMonths(1);
		LocalDate fechaAltaSalida = fecha;
		String lugar = "lugar";
		int cantMaxTuristas = 2;

		contrUsuario.altaTurista(nickname, nombre, apellido, correo, "1234", fNacimiento, null, nacionalidad);
		contrUsuario.altaTurista(nickname + "2", nombre, apellido, correo + "2", "1234", fNacimiento, null,
				nacionalidad);
		contrActTur.altaDepartamento(departamento, descripcion, departamento);
		contrUsuario.altaProveedor(nombreProveedor, nombreProveedor, nombreProveedor, nombreProveedor, nombreProveedor,
				fechaAlta, null, nombreProveedor, nombreProveedor);
		contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion, duracion, costo,
				ciudad, fechaAlta, null, muestraCategorias, null);
		contrActTur.cambiarEstadoDeActividadTuristica(nombreActividad, EstadoActividadTuristica.ACEPTADA);
		contrActTur.altaSalidaTuristica(nombreActividad, nombreSalida, fechaHoraSalida, fechaAltaSalida, lugar,
				cantMaxTuristas, null);
		contrActTur.altaInscripcionSalidaTuristica(nombreSalida, nickname, 1, localDateNow, null);

		assertThrows(SuperaElMaximoDeTuristasException.class, () -> {
			contrActTur.altaInscripcionSalidaTuristica(nombreSalida, nickname + "2", 2, localDateNow, null);
		});
	}

	@Test
	public void testAltaInscripcionConConsumosInsuficientes() throws TurismoUyException {
		String idTest = "altaInscripcionConConsumosInsuficientes";

		List<String> nombresTuristas = ControladorUsuarioTest.generarTuristas(1, idTest);
		ControladorUsuarioTest.generarProveedores(1, idTest);
		generarDepartamentos(1, idTest);
		List<String> nombresActividades = generarActividades(1, idTest);

		aceptarActividades(nombresActividades);

		String nombreSalida1 = "salida1-altaInscripcionConConsumosInsuficientes";
		String nombreSalida2 = "salida2-altaInscripcionConConsumosInsuficientes";
		contrActTur.altaSalidaTuristica(nombresActividades.get(0), nombreSalida1, localDateTimeNow.plusDays(20),
				localDateNow, "lugar", 10, null);
		contrActTur.altaSalidaTuristica(nombresActividades.get(0), nombreSalida2, localDateTimeNow.plusDays(20),
				localDateNow, "lugar", 10, null);
		List<String> nombresPaquetes = ControladorPaqueteTest.generarPaquetes(1, idTest);
		controladorPaquete.agregarActividadAPaquete(nombresActividades.get(0), nombresPaquetes.get(0));
		controladorPaquete.comprarPaquete(nombresTuristas.get(0), nombresPaquetes.get(0), 3, null);

		contrActTur.altaInscripcionSalidaTuristica(nombreSalida1, nombresTuristas.get(0), 2, null,
				nombresPaquetes.get(0));
		assertThrows(CompraConConsumosInsuficientesExcepcion.class,
				() -> contrActTur.altaInscripcionSalidaTuristica(nombreSalida2, nombresTuristas.get(0), 2, null,
						nombresPaquetes.get(0)));
	}

	@Test
	public void testAltaInscripcionConCompraVencida() throws TurismoUyException {
		String idTest = "altaInscripcionConCompraVencida";

		List<String> nombresTuristas = ControladorUsuarioTest.generarTuristas(2, idTest);
		generarDepartamentos(2, idTest);
		ControladorUsuarioTest.generarProveedores(2, idTest);
		List<String> nombresActividades = generarActividades(2, idTest);

		aceptarActividades(nombresActividades);

		List<String> nombreSalidas = generarSalidas(2, idTest);
		List<String> nombresPaquetes = ControladorPaqueteTest.generarPaquetes(2, idTest);
		controladorPaquete.agregarActividadAPaquete(nombresActividades.get(0), nombresPaquetes.get(0));
		controladorPaquete.agregarActividadAPaquete(nombresActividades.get(1), nombresPaquetes.get(1));
		controladorPaquete.comprarPaquete(nombresTuristas.get(0), nombresPaquetes.get(0), 10, null);
		controladorPaquete.comprarPaquete(nombresTuristas.get(1), nombresPaquetes.get(1), 10, null);

		contrActTur.altaInscripcionSalidaTuristica(nombreSalidas.get(0), nombresTuristas.get(0), 2,
				localDateNow.plusDays(15), nombresPaquetes.get(0)); // Con 15
																	// dias de
																	// mas esta
																	// apunto de
																	// excederse
																	// de la
																	// fecha de
																	// vencimiento
		assertThrows(CompraPaqueteVencidoExcepcion.class,
				() -> contrActTur.altaInscripcionSalidaTuristica(nombreSalidas.get(1), nombresTuristas.get(1), 2,
						localDateNow.plusDays(16), nombresPaquetes.get(1)));
		// Con 16 dias de mas directamente se excede
	}

	@Test
	public void testAltaInscripcionConPaqueteNoComprado() throws TurismoUyException {
		String idTest = "altaInscripcionConPaqueteNoComprado";
		List<String> nombresTuristas = ControladorUsuarioTest.generarTuristas(1, idTest);
		generarDepartamentos(1, idTest);
		ControladorUsuarioTest.generarProveedores(1, idTest);
		List<String> nombresActividades = generarActividades(1, idTest);

		aceptarActividades(nombresActividades);

		List<String> nombreSalidas = generarSalidas(1, idTest);
		List<String> nombresPaquetes = ControladorPaqueteTest.generarPaquetes(1, idTest);
		controladorPaquete.agregarActividadAPaquete(nombresActividades.get(0), nombresPaquetes.get(0));
		assertThrows(PaqueteNoCompradoExcepcion.class,
				() -> contrActTur.altaInscripcionSalidaTuristica(nombreSalidas.get(0), nombresTuristas.get(0), 2, null,
						nombresPaquetes.get(0)));
	}

	@Test
	public void testAltaInscripcionConPaqueteSinActividad() throws TurismoUyException {
		String idTest = "altaInscripcionConPaqueteSinActividad";
		List<String> nombresTuristas = ControladorUsuarioTest.generarTuristas(1, idTest);
		generarDepartamentos(2, idTest);
		ControladorUsuarioTest.generarProveedores(2, idTest);
		List<String> nombresActividades = generarActividades(2, idTest);

		aceptarActividades(nombresActividades);

		List<String> nombreSalidas = generarSalidas(1, idTest);
		List<String> nombresPaquetes = ControladorPaqueteTest.generarPaquetes(1, idTest);
		controladorPaquete.agregarActividadAPaquete(nombresActividades.get(1), nombresPaquetes.get(0));
		controladorPaquete.comprarPaquete(nombresTuristas.get(0), nombresPaquetes.get(0), 2, null);
		assertThrows(NoExisteConsumoParaLaActividadExcepcion.class,
				() -> contrActTur.altaInscripcionSalidaTuristica(nombreSalidas.get(0), nombresTuristas.get(0), 2, null,
						nombresPaquetes.get(0)));
	}

	@Test
	public void testAltaSalidaTuristicaOK() throws TurismoUyException {
		String idTest = "testAltaSalidaTuristicaOK";

		assertTrue(contrActTur != null);

		for (int i = 0; i < 100; i++) {

			String nombreProveedor = "Proveedor " + idTest + " i=" + (i % 10);
			String departamento = "Departamento " + idTest + " i=" + (i % 10);
			String nombreActividad = "Actividad " + idTest + " i=" + i;
			String descripcion = "Desc";
			int duracion = 10;
			float costo = (float) 10;
			String ciudad = "Ciudad";
			LocalDate fechaAlta = localDateNow;

			String nombreSalida = "Salida " + idTest + i;
			LocalDate fecha = localDateNow;
			LocalDateTime fechaHoraSalida = localDateTimeNow.plusMonths(1);
			LocalDate fechaAltaSalida = fecha;
			String lugar = "lugar";
			int cantMaxTuristas = 10;

			try {
				contrActTur.altaDepartamento(departamento, descripcion, departamento);
			} catch (DeparamentoYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}
			try {
				Fabrica.getInstancia().getIControladorUsuario().altaProveedor(nombreProveedor, nombreProveedor,
						nombreProveedor, nombreProveedor, nombreProveedor, fechaAlta, null, nombreProveedor,
						nombreProveedor);
			} catch (UsuarioYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}

			contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion, duracion,
					costo, ciudad, fechaAlta, null, muestraCategorias, null);
			contrActTur.cambiarEstadoDeActividadTuristica(nombreActividad, EstadoActividadTuristica.ACEPTADA);
			contrActTur.altaSalidaTuristica(nombreActividad, nombreSalida, fechaHoraSalida, fechaAltaSalida, lugar,
					cantMaxTuristas, null);

			// assertTrue(cat.existeSalidaTuristica(nombreSalida));

			DTSalidaTuristica sal = contrActTur.obtenerDTSalidaTuristica(nombreSalida);
			assertTrue(sal != null);

			assertEquals(nombreSalida, sal.getNombre());
			assertEquals(fechaAlta, sal.getFechaAlta());
			assertEquals(lugar, sal.getLugarSalida());
			assertEquals(cantMaxTuristas, sal.getCantMaxTuristas());

			DTSalidaTuristicaDetalle salDetalle = contrActTur.obtenerDTSalidaTuristicaDetalle(nombreSalida);
			assertTrue(salDetalle.getInscripciones().isEmpty());
		}
	}

	@Test
	public void testAltaSalidaTuristicaSinFecha() throws TurismoUyException {
		String idTest = "testAltaSalidaTuristicaSinFecha";

		assertTrue(contrActTur != null);

		for (int i = 0; i < 100; i++) {

			String nombreProveedor = "Proveedor " + idTest + " i=" + (i % 10);
			String departamento = "Departamento " + idTest + " i=" + (i % 10);
			String nombreActividad = "Actividad " + idTest + " i=" + i;
			String descripcion = "Desc";
			int duracion = 10;
			float costo = (float) 10;
			String ciudad = "Ciudad";
			LocalDate fechaAlta = localDateNow;

			String nombreSalida = "Salida " + idTest + i;
			LocalDateTime fechaHoraSalida = localDateTimeNow.plusMonths(1);
			LocalDate fechaAltaSalida = null;
			String lugar = "lugar";
			int cantMaxTuristas = 10;

			try {
				contrActTur.altaDepartamento(departamento, descripcion, departamento);
			} catch (TurismoUyException exception) {
				// OK, falla porque creamos repetidos a propósito
			}
			try {
				Fabrica.getInstancia().getIControladorUsuario().altaProveedor(nombreProveedor, nombreProveedor,
						nombreProveedor, nombreProveedor, nombreProveedor, fechaAlta, null, nombreProveedor,
						nombreProveedor);
			} catch (TurismoUyException exception) {
				// OK, falla porque creamos repetidos a propósito
			}

			contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion, duracion,
					costo, ciudad, fechaAlta, null, muestraCategorias, null);
			contrActTur.cambiarEstadoDeActividadTuristica(nombreActividad, EstadoActividadTuristica.ACEPTADA);

			contrActTur.altaSalidaTuristica(nombreActividad, nombreSalida, fechaHoraSalida, fechaAltaSalida, lugar,
					cantMaxTuristas, null);
			DTSalidaTuristica sal = contrActTur.obtenerDTSalidaTuristica(nombreSalida);
			assertTrue(sal != null);
			assertNotEquals(fechaAltaSalida, sal.getFechaAlta());
		}
	}

	@Test
	public void testAltaSalidaTuristicaRepetida() throws TurismoUyException {
		String identif = "testAltaSalidaTuristicaRepetida";

		assertTrue(contrActTur != null);

		for (int i = 0; i < 2; i++) {

			String nombreProveedor = "Proveedor " + identif + " i=" + (i % 10);
			String departamento = "Departamento " + identif + " i=" + (i % 10);
			String descripcion = "Desc";
			LocalDate fechaAlta = localDateNow;

			try {
				contrActTur.altaDepartamento(departamento, descripcion, departamento);
			} catch (DeparamentoYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}
			try {
				Fabrica.getInstancia().getIControladorUsuario().altaProveedor(nombreProveedor, nombreProveedor,
						nombreProveedor, nombreProveedor, nombreProveedor, fechaAlta, null, nombreProveedor,
						nombreProveedor);
			} catch (UsuarioYaRegistradoException exception) {
				// Esperable, no pasa nada.
			}

			try {
				contrActTur.altaDepartamento(departamento, descripcion, departamento);
			} catch (TurismoUyException exception) {
				// OK, falla porque creamos repetidos a propósito
			}
			try {
				Fabrica.getInstancia().getIControladorUsuario().altaProveedor(nombreProveedor, nombreProveedor,
						nombreProveedor, nombreProveedor, nombreProveedor, fechaAlta, null, nombreProveedor,
						nombreProveedor);
			} catch (TurismoUyException exception) {
				// OK, falla porque creamos repetidos a propósito
			}

		}
	}

	@Test
	public void testAltaSalidaTuristicaFewchaAltaActividadPosteriorASalida() throws TurismoUyException {
		String identif = "testAltaSalidaTuristicaFewchaAltaActividadPosteriorASalida";

		assertTrue(contrActTur != null);
		String nombreProveedor = "Proveedor " + identif;
		String departamento = "Departamento " + identif;
		String nombreActividad = "Actividad " + identif;
		String descripcion = "Desc";
		int duracion = 10;
		float costo = (float) 10;
		String ciudad = "Ciudad";
		LocalDate fechaAlta = localDateNow;

		String nombreSalida = "Salida " + identif;
		LocalDate fecha = localDateNow;
		LocalDateTime fechaHoraSalida = localDateTimeNow.minusMonths(1);
		LocalDate fechaAltaSalida = fecha;
		String lugar = "lugar";
		int cantMaxTuristas = 10;

		try {
			contrActTur.altaDepartamento(departamento, descripcion, departamento);
		} catch (DeparamentoYaRegistradoException exception) {
			// Esperable, no pasa nada.
		}
		try {
			Fabrica.getInstancia().getIControladorUsuario().altaProveedor(nombreProveedor, nombreProveedor,
					nombreProveedor, nombreProveedor, nombreProveedor, fechaAlta, null, nombreProveedor,
					nombreProveedor);
		} catch (UsuarioYaRegistradoException exception) {
			// Esperable, no pasa nada.
		}

		contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion, duracion, costo,
				ciudad, fechaAlta, null, muestraCategorias, null);

		assertThrows(FechaAltaSalidaPosteriorAFechaSalidaException.class, () -> {
			contrActTur.altaSalidaTuristica(nombreActividad, nombreSalida, fechaHoraSalida, fechaAltaSalida, lugar,
					cantMaxTuristas, null);
		});
	}

	@Test
	public void testAltaSalidaTuristicaFechaAltaActividadPosteriorAFechaAltaSalidaException()
			throws TurismoUyException {
		assertTrue(contrActTur != null);
		String nombreProveedor = "Proveedor testAltaSalidaTuristicaFechaAltaSalidaPosteriorAFechaSalida";
		String departamento = "Departamento testAltaSalidaTuristicaFechaAltaSalidaPosteriorAFechaSalida";
		String nombreActividad = "Actividad testAltaSalidaTuristicaFechaAltaSalidaPosteriorAFechaSalida";
		String descripcion = "Desc";
		int duracion = 10;
		float costo = (float) 10;
		String ciudad = "Ciudad";
		LocalDate fechaAlta = localDateNow.plusMonths(1);

		String nombreSalida = "Salida testAltaSalidaTuristicaFechaAltaSalidaPosteriorAFechaSalida";
		LocalDateTime fechaHoraSalida = localDateTimeNow;
		LocalDate fechaAltaSalida = fechaHoraSalida.toLocalDate();
		String lugar = "lugar";
		int cantMaxTuristas = 10;

		try {
			contrActTur.altaDepartamento(departamento, descripcion, departamento);
		} catch (DeparamentoYaRegistradoException exception) {
			// Esperable, no pasa nada.
		}
		try {
			Fabrica.getInstancia().getIControladorUsuario().altaProveedor(nombreProveedor, nombreProveedor,
					nombreProveedor, nombreProveedor, nombreProveedor, fechaAlta, null, nombreProveedor,
					nombreProveedor);
		} catch (UsuarioYaRegistradoException exception) {
			// Esperable, no pasa nada.
		}

		contrActTur.altaActividadTuristica(nombreProveedor, departamento, nombreActividad, descripcion, duracion, costo,
				ciudad, fechaAlta, null, muestraCategorias, null);

		assertThrows(FechaAltaActividadPosteriorAFechaAltaSalidaException.class, () -> {
			contrActTur.altaSalidaTuristica(nombreActividad, nombreSalida, fechaHoraSalida, fechaAltaSalida, lugar,
					cantMaxTuristas, null);
		});
	}

	@Test
	public void testCategorias() throws TurismoUyException {
		generarCategorias(100, "testCategorias");

		var categorias = contrActTur.obtenerIdCategorias();

		var categoriasTest = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			String nom = "Categoria testCategorias i=" + i;
			categoriasTest.add(nom);
		}

		categoriasTest.forEach((var cat) -> assertTrue(categorias.contains(cat)));
	}

	@Test
	public void testObtenerIdActividadesTuristicasConfirmadasPorCategoria() throws TurismoUyException {
		String idTest = "testObtenerIdActividadesTuristicasConfirmadasPorCategoria";
		generarDepartamentos(2, idTest);
		ControladorUsuarioTest.generarProveedores(2, idTest);
		generarActividades(2, idTest);

		contrActTur.cambiarEstadoDeActividadTuristica("Actividad " + idTest + " i=0",
				EstadoActividadTuristica.ACEPTADA);
		contrActTur.cambiarEstadoDeActividadTuristica("Actividad " + idTest + " i=1",
				EstadoActividadTuristica.RECHAZADA);

		for (int i = 0; i < muestraCategorias.size(); i++) {
			var actividades = contrActTur
					.obtenerIdActividadesTuristicasConfirmadasPorCategoria(muestraCategorias.get(i));
			assertTrue(actividades.contains("Actividad " + idTest + " i=0"));
			assertFalse(actividades.contains("Actividad " + idTest + " i=1"));
		}
	}

	@Test
	public void testObtenerDTActividadesTuristicas() throws TurismoUyException {
		String idTest = "testObtenerDTActividadesTuristicas";
		generarDepartamentos(2, idTest);
		ControladorUsuarioTest.generarProveedores(2, idTest);
		generarActividades(2, idTest);

		contrActTur.cambiarEstadoDeActividadTuristica("Actividad " + idTest + " i=0",
				EstadoActividadTuristica.ACEPTADA);
		contrActTur.cambiarEstadoDeActividadTuristica("Actividad " + idTest + " i=1",
				EstadoActividadTuristica.RECHAZADA);

		var actividades = contrActTur.obtenerDTActividadesTuristicas();

		boolean esta0 = false;
		boolean esta1 = false;
		for (DTActividadTuristica dtActividadTuristica : actividades) {
			if (dtActividadTuristica.getNombre().equals("Actividad " + idTest + " i=0"))
				esta0 = true;
			if (dtActividadTuristica.getNombre().equals("Actividad " + idTest + " i=1"))
				esta1 = true;
		}

		assertTrue(esta0);
		assertFalse(esta1);
	}

	@Test
	public void testObtenerDTActividadesTuristicasConfirmadasPorDepartamento() throws TurismoUyException {
		String idTest = "testObtenerDTActividadesTuristicasConfirmadasPorDepartamento";
		generarDepartamentos(5, idTest);
		ControladorUsuarioTest.generarProveedores(5, idTest);
		generarActividades(5, idTest);

		contrActTur.cambiarEstadoDeActividadTuristica("Actividad " + idTest + " i=0",
				EstadoActividadTuristica.ACEPTADA);
		contrActTur.cambiarEstadoDeActividadTuristica("Actividad " + idTest + " i=1",
				EstadoActividadTuristica.RECHAZADA);

		String dep = "Departamento " + idTest + " i=0";
		var actividades = contrActTur.obtenerDTActividadesTuristicasConfirmadasPorDepartamento(dep);

		boolean[] esta = new boolean[1];
		esta[0] = false;

		actividades.forEach((var actividad) -> {
			esta[0] = esta[0] || actividad.getNombre().equals("Actividad " + idTest + " i=0");
		});
		assertTrue(esta[0]);

		dep = "Departamento " + idTest + " i=1";
		actividades = contrActTur.obtenerDTActividadesTuristicasConfirmadasPorDepartamento(dep);

		esta[0] = false;

		actividades.forEach((var actividad) -> {
			esta[0] = esta[0] || actividad.getNombre().equals("Actividad " + idTest + " i=1");
		});
		assertFalse(esta[0]);

	}

	@Test
	public void testObtenerIdActividadesTuristicasAgregadas() throws TurismoUyException {
		String idTest = "testObtenerIdActividadesTuristicasAgregadas";
		generarDepartamentos(3, idTest);
		ControladorUsuarioTest.generarProveedores(3, idTest);
		generarActividades(3, idTest);

		var actividades = contrActTur.obtenerIdActividadesTuristicasAgregadas();

		assertTrue(actividades.contains("Actividad " + idTest + " i=0"));
		assertTrue(actividades.contains("Actividad " + idTest + " i=1"));
		assertTrue(actividades.contains("Actividad " + idTest + " i=2"));

	}

	@Test
	public void testObtenerIdComprasDisponiblesParaInscripcionOK() throws TurismoUyException {

		String idTest = "testObtenerIdComprasDisponiblesParaInscripcionOK";

		List<String> nombreTuristas = ControladorUsuarioTest.generarTuristas(1, idTest);
		ControladorUsuarioTest.generarProveedores(2, idTest);
		generarDepartamentos(2, idTest);
		List<String> nombreActividades = generarActividades(2, idTest);

		aceptarActividades(nombreActividades);

		List<String> nombreSalidas = generarSalidas(2, idTest);
		List<String> nombrePaquetes = ControladorPaqueteTest.generarPaquetes(2, idTest);

		controladorPaquete.agregarActividadAPaquete(nombreActividades.get(0), nombrePaquetes.get(0));
		controladorPaquete.agregarActividadAPaquete(nombreActividades.get(0), nombrePaquetes.get(1));
		controladorPaquete.agregarActividadAPaquete(nombreActividades.get(1), nombrePaquetes.get(1));

		List<String> comprasDisponibles = contrActTur
				.obtenerIdComprasDisponiblesParaInscripcion(nombreActividades.get(0), nombreTuristas.get(0));
		assertEquals(0, comprasDisponibles.size());

		controladorPaquete.comprarPaquete(nombreTuristas.get(0), nombrePaquetes.get(0), 1, null);
		controladorPaquete.comprarPaquete(nombreTuristas.get(0), nombrePaquetes.get(1), 1, null);

		comprasDisponibles = contrActTur.obtenerIdComprasDisponiblesParaInscripcion(nombreActividades.get(0),
				nombreTuristas.get(0));
		assertEquals(2, comprasDisponibles.size());

		contrActTur.altaInscripcionSalidaTuristica(nombreSalidas.get(0), nombreTuristas.get(0), 1, localDateNow,
				nombrePaquetes.get(0));
		comprasDisponibles = contrActTur.obtenerIdComprasDisponiblesParaInscripcion(nombreActividades.get(0),
				nombreTuristas.get(0));
		assertEquals(1, comprasDisponibles.size());

		contrActTur.altaInscripcionSalidaTuristica(nombreSalidas.get(1), nombreTuristas.get(0), 1, localDateNow,
				nombrePaquetes.get(1));

		comprasDisponibles = contrActTur.obtenerIdComprasDisponiblesParaInscripcion(nombreActividades.get(0),
				nombreTuristas.get(0));
		assertEquals(1, comprasDisponibles.size());
	}

	@Test
	public void testCambiarEstadoActividad() throws TurismoUyException {
		String idTest = "testCambiarEstadoActividad";
		ControladorUsuarioTest.generarProveedores(3, idTest);
		generarDepartamentos(3, idTest);

		for (int i = 0; i < 3; i++) {
			String nickProveedor = "Proveedor " + idTest + " i=" + i;
			String departamento = "Departamento " + idTest + " i=" + i;
			String nombreActividad = "Actividad " + idTest + " i=" + i;
			String descripcion = "Desc";
			int duracion = 10;
			float costo = (float) 10.85;
			String ciudad = "Ciudad";
			LocalDate fechaAlta = localDateNow;

			contrActTur.altaActividadTuristica(nickProveedor, departamento, nombreActividad, descripcion, duracion,
					costo, ciudad, fechaAlta, null, muestraCategorias, null);
		}

		contrActTur.cambiarEstadoDeActividadTuristica("Actividad " + idTest + " i=0",
				EstadoActividadTuristica.ACEPTADA);
		contrActTur.cambiarEstadoDeActividadTuristica("Actividad " + idTest + " i=1",
				EstadoActividadTuristica.RECHAZADA);
		contrActTur.cambiarEstadoDeActividadTuristica("Actividad " + idTest + " i=2",
				EstadoActividadTuristica.FINALIZADA);

		assertEquals(EstadoActividadTuristica.ACEPTADA,
				contrActTur.obtenerDTActividadTuristicaDetalle("Actividad " + idTest + " i=0").getEstado());
		assertEquals(EstadoActividadTuristica.RECHAZADA,
				contrActTur.obtenerDTActividadTuristicaDetalle("Actividad " + idTest + " i=1").getEstado());
		assertEquals(EstadoActividadTuristica.FINALIZADA,
				contrActTur.obtenerDTActividadTuristicaDetalle("Actividad " + idTest + " i=2").getEstado());
	}

	@Test
	public void testPersistencia() throws TurismoUyException {
		String idTest = "testPersistencia";
		int cant = 1;
		int cantSalidas = 10;
		int cont = 0;

		ControladorUsuarioTest.generarProveedores(cant, idTest);
		generarDepartamentos(cant, idTest);

		String nickProveedor = "Proveedor " + idTest + " i=" + cont;
		String departamento = "Departamento " + idTest + " i=" + cont;
		String nombreActividad = "Actividad " + idTest + " i=" + cont;
		String descripcion = "Desc";
		int duracion = 10;
		float costo = (float) 10.85;
		String ciudad = "Ciudad";
		LocalDate fechaAlta = localDateNow.minusDays(4);

		contrActTur.altaActividadTuristica(nickProveedor, departamento, nombreActividad, descripcion, duracion, costo,
				ciudad, fechaAlta, null, muestraCategorias, null);

		contrActTur.cambiarEstadoDeActividadTuristica("Actividad " + idTest + " i=0",
				EstadoActividadTuristica.ACEPTADA);

		for (int i1 = 0; i1 < cantSalidas; i1++) {
			String nombreSalida = "Salida " + idTest + " i=" + i1;
			String ciudadSal = "Ciudad salida";
			LocalDate fechaAltaSal = localDateNow.minusDays(3);
			LocalDateTime fechaYHoraSalida = localDateTimeNow.minusDays(2);
			int cantMaxTur = 50;

			contrActTur.altaSalidaTuristica(nombreActividad, nombreSalida, fechaYHoraSalida, fechaAltaSal, ciudadSal,
					cantMaxTur, null);

			ControladorUsuarioTest.generarTuristas(1, nombreSalida);

			contrActTur.altaInscripcionSalidaTuristica(nombreSalida, "Turista " + nombreSalida + " i=0", cant,
					fechaAltaSal.plusDays(1), null);
		}

		contrActTur.cambiarEstadoDeActividadTuristica("Actividad " + idTest + " i=0",
				EstadoActividadTuristica.FINALIZADA);

		var actFin = contrActTur.obtenerDTActividadTuristicaDetalle(nombreActividad);

		assertEquals(null, actFin.getImg());
		assertEquals(nombreActividad, actFin.getNombre());
		assertEquals(departamento, actFin.getDepartamento());
		assertEquals(nickProveedor, actFin.getNicknameProveedor());

		var salidasEnDT = actFin.getSalidas().keySet();
		for (int i1 = 0; i1 < cantSalidas; i1++) {
			String nombreSalida = "Salida " + idTest + " i=" + i1;
			String nickname = "Turista " + nombreSalida + " i=0";

			assertTrue(salidasEnDT.contains(nombreSalida));

			DTTuristaDetallePrivado turDT = (DTTuristaDetallePrivado) contrUsuario
					.obtenerDTUsuarioDetallePrivado(nickname);
			assertEquals(nombreSalida, turDT.getInscripciones().get(0).getNombre());
		}

		DTProveedorDetallePrivado provDT = (DTProveedorDetallePrivado) contrUsuario
				.obtenerDTUsuarioDetallePrivado(nickProveedor);
		var actDentroProv = provDT.getActividadesNoConfirmadas().get(EstadoActividadTuristica.FINALIZADA).get(0);
		assertEquals(nombreActividad, actDentroProv.getNombre());
	}

	@Test
	void filtrarActividadesTest() throws TurismoUyException {
		String idTest = "filtrarActividadesTest";
		String idTestNoFiltrable = "filtrar_______ActividadesTest";
		List<String> prov = ControladorUsuarioTest.generarProveedores(1, idTest);
		List<String> departamentos = ControladorActividadTuristicaTest.generarDepartamentos(3, idTest);
		String idCat1 = idTest + " cat1";
		String idCat2 = idTest + " cat2";
		contrActTur.altaCategoria(idCat1);
		contrActTur.altaCategoria(idCat2);

		String[] nombreAct = { "_1" + idTest, "_2" + idTestNoFiltrable, "_3" + idTestNoFiltrable, "_4" + idTest,
				"_5" + idTest, "_6" + idTest };

		contrActTur.altaActividadTuristica(prov.get(0), departamentos.get(0), nombreAct[0], "AAAAA", 1, (float) 1.0,
				"aaa", localDateNow.minusDays(5), null, List.of(idCat1), null);
		contrActTur.altaActividadTuristica(prov.get(0), departamentos.get(0), nombreAct[1], "AA" + idTest + " AAA", 1,
				(float) 1.0, "aaa", localDateNow.minusDays(4), null, List.of(idCat1), null);
		contrActTur.altaActividadTuristica(prov.get(0), departamentos.get(0), nombreAct[2], "AAAAA", 1, (float) 1.0,
				"aaa", localDateNow.minusDays(3), null, List.of(idCat1), null);
		contrActTur.altaActividadTuristica(prov.get(0), departamentos.get(1), nombreAct[3], "AAAAA", 1, (float) 1.0,
				"aaa", localDateNow.minusDays(2), null, List.of(idCat1), null);
		contrActTur.altaActividadTuristica(prov.get(0), departamentos.get(1), nombreAct[4], "AAAAA", 1, (float) 1.0,
				"aaa", localDateNow.minusDays(1), null, List.of(idCat1, idCat2), null);
		contrActTur.altaActividadTuristica(prov.get(0), departamentos.get(2), nombreAct[5], "AAAAA", 1, (float) 1.0,
				"aaa", localDateNow.minusDays(0), null, List.of(idCat2), null);

		for (int i = 0; i < 6; i++) {
			contrActTur.cambiarEstadoDeActividadTuristica(nombreAct[i], EstadoActividadTuristica.ACEPTADA);
		}

		List<DTActividadTuristica> resultadoFiltrado = contrActTur.filtrarActividades(idTest, null, null,
				TipoOrdenacion.ALFABETICAMENTE);
		assertEquals(5, resultadoFiltrado.size());
		assertEquals(nombreAct[0], resultadoFiltrado.get(0).getNombre());
		assertEquals(nombreAct[5], resultadoFiltrado.get(4).getNombre());

		resultadoFiltrado = contrActTur.filtrarActividades(idTest, departamentos.get(0), null,
				TipoOrdenacion.FECHA_PUBLICACION);
		assertEquals(2, resultadoFiltrado.size());
		assertEquals(nombreAct[1], resultadoFiltrado.get(0).getNombre());
		assertEquals(nombreAct[0], resultadoFiltrado.get(1).getNombre());

		resultadoFiltrado = contrActTur.filtrarActividades(idTest, null, idCat1, TipoOrdenacion.FECHA_PUBLICACION);
		assertEquals(4, resultadoFiltrado.size());
		assertEquals(nombreAct[4], resultadoFiltrado.get(0).getNombre());
		assertEquals(nombreAct[3], resultadoFiltrado.get(1).getNombre());
		assertEquals(nombreAct[1], resultadoFiltrado.get(2).getNombre());
		assertEquals(nombreAct[0], resultadoFiltrado.get(3).getNombre());

	}

}

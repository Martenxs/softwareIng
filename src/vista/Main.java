package vista;

import controlador.ProductoControlador;
import modelo.*;
import servicios.Singleton;
import servicios.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main extends Application {
    private ProductoControlador controlador;
    private ListView<String> listaProductos;
    private TextField idField, descripcionField, precioField, extraField, minPrecioField, maxPrecioField, montoField;
    private ComboBox<String> tipoProducto, metodoPago;

    @Override
    public void start(Stage primaryStage) throws SQLException {
        Connection conexion = Singleton.getInstance().getConnection();
        controlador = new ProductoControlador(conexion);

        // Campos de inicio de sesión
        TextField loginId = new TextField();
        loginId.setPromptText("ID");

        TextField loginNombre = new TextField();
        loginNombre.setPromptText("Nombre");

        Button btnSave = new Button("Save");
        btnSave.setOnAction(e -> {
            String id = loginId.getText();
            String nombre = loginNombre.getText();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setHeaderText("Mensaje");
            alert.setContentText("Cliente [id=" + id + ", nombres=" + nombre + "]");
            alert.show();
        });

        listaProductos = new ListView<>();

        idField = new TextField();
        idField.setPromptText("ID");

        descripcionField = new TextField();
        descripcionField.setPromptText("Descripción");

        precioField = new TextField();
        precioField.setPromptText("Precio");

        extraField = new TextField();
        extraField.setPromptText("Voltaje o Calorías");

        tipoProducto = new ComboBox<>();
        tipoProducto.getItems().addAll("Electronico", "Alimento");
        tipoProducto.setValue("Electronico");

        Button btnAgregar = new Button("Agregar Producto");
        btnAgregar.setOnAction(e -> agregarProducto());

        Button btnClonar = new Button("Clonar Seleccionado");
        btnClonar.setOnAction(e -> clonarProducto());

        minPrecioField = new TextField();
        minPrecioField.setPromptText("Precio mínimo");

        maxPrecioField = new TextField();
        maxPrecioField.setPromptText("Precio máximo");

        Button btnBuscar = new Button("Buscar por Rango");
        btnBuscar.setOnAction(e -> buscarPorRango());

        // 🔹 **Campos para realizar pagos**
        montoField = new TextField();
        montoField.setPromptText("Ingrese monto");

        metodoPago = new ComboBox<>();
        metodoPago.getItems().addAll("Nequi", "PayPal");
        metodoPago.setValue("Nequi");

        Button btnPagar = new Button("Realizar Pago");
        btnPagar.setOnAction(e -> realizarPago());

        VBox layout = new VBox(10, loginId, loginNombre, btnSave,
                idField, descripcionField, precioField, extraField, tipoProducto,
                btnAgregar, btnClonar, minPrecioField, maxPrecioField, btnBuscar,
                listaProductos,
                new Label("Método de Pago:"), metodoPago, montoField, btnPagar);  // 🔹 **Nueva sección para pagos**

        Scene scene = new Scene(layout, 400, 650);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestión de Productos y Pagos");
        primaryStage.show();

        actualizarLista();
    }

    private void agregarProducto() {
        try {
            int id = Integer.parseInt(idField.getText());
            String descripcion = descripcionField.getText();
            double precio = Double.parseDouble(precioField.getText());
            String tipo = tipoProducto.getValue();

            Producto producto;
            if ("Electronico".equals(tipo)) {
                double voltaje = Double.parseDouble(extraField.getText());
                producto = new ProductoElectronico(id, descripcion, precio, voltaje);
            } else {
                int calorias = Integer.parseInt(extraField.getText());
                producto = new ProductoAlimentos(id, descripcion, precio, calorias);
            }

            controlador.agregarProducto(producto);
            actualizarLista();
        } catch (NumberFormatException e) {
            System.out.println("Error en los valores ingresados");
        }
    }

    private void clonarProducto() {
        int index = listaProductos.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            List<Producto> productos = controlador.obtenerProductos();
            Producto original = productos.get(index);
            Producto clon = controlador.clonarProducto(original);
            controlador.agregarProducto(clon);
            actualizarLista();
        }
    }

    private void buscarPorRango() {
        try {
            double minPrecio = Double.parseDouble(minPrecioField.getText());
            double maxPrecio = Double.parseDouble(maxPrecioField.getText());

            listaProductos.getItems().clear();
            List<Producto> productosFiltrados = controlador.buscarPorRangoDePrecio(minPrecio, maxPrecio);

            for (Producto p : productosFiltrados) {
                listaProductos.getItems().add(p.getDescripcion() + " - $" + p.getPrecio());
            }
        } catch (NumberFormatException e) {
            System.out.println("Error en los valores de búsqueda");
        }
    }

    private void actualizarLista() {
        listaProductos.getItems().clear();
        List<Producto> productos = controlador.obtenerProductos();
        for (Producto p : productos) {
            listaProductos.getItems().add(p.getDescripcion() + " - $" + p.getPrecio());
        }
    }

    // 🔹 **Método para realizar pagos**
    private void realizarPago() {
        try {
            double monto = Double.parseDouble(montoField.getText());
            Pago pago;

            if (metodoPago.getValue().equals("Nequi")) {
                pago = new NequiAdapter(new Nequi());
            } else {
                pago = new PayPalAdapter(new PayPal());
            }

            pago.realizarPago(monto);
            mostrarMensaje("Pago realizado", "Pago exitoso de $" + monto + " con " + metodoPago.getValue());
        } catch (NumberFormatException e) {
            mostrarMensaje("Error", "Ingrese un monto válido.");
        }
    }

    private void mostrarMensaje(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(contenido);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


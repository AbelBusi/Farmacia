CREATE DATABASE farmacia;
USE farmacia;

-- Tabla Proveedor
CREATE TABLE Proveedor (
    id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    contacto VARCHAR(100),
    telefono VARCHAR(15)
);

-- Tabla TipoMedicamento
CREATE TABLE TipoMedicamento (
    id_tipo INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    descripcion TEXT
);

-- Tabla Medicamento
CREATE TABLE Medicamento (
    id_medicamento INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    descripcion TEXT,
    precio DECIMAL(10, 2),
    stock INT,
    fechaVencimiento DATE,
    id_tipo INT,
    FOREIGN KEY (id_tipo) REFERENCES TipoMedicamento(id_tipo)
);

-- Tabla Compra
CREATE TABLE Compra (
    id_compra INT PRIMARY KEY AUTO_INCREMENT,
    id_proveedor INT,
    total DECIMAL(10, 2),
    fechaCompra DATE,
    vigente BOOLEAN,
    FOREIGN KEY (id_proveedor) REFERENCES Proveedor(id_proveedor)
);

-- Tabla detalleCompra
CREATE TABLE detalleCompra (
    id_detalleCompra INT PRIMARY KEY AUTO_INCREMENT,
    id_compra INT,
    id_medicamento INT,
    stock INT,
    precioUnitario DECIMAL(10, 2),
    FOREIGN KEY (id_compra) REFERENCES Compra(id_compra),
    FOREIGN KEY (id_medicamento) REFERENCES Medicamento(id_medicamento)
);

-- Tabla Cliente
CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombres VARCHAR(100),
    apellidos VARCHAR(100),
    dni VARCHAR(8),
    direccion TEXT,
    telefono VARCHAR(15)
);

-- Tabla Usuario
CREATE TABLE Usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombres VARCHAR(100),
    apellidos VARCHAR(100),
    dni VARCHAR(8),
    telefono VARCHAR(15),
    correo VARCHAR(100),
    clave VARCHAR(255),
    estado BOOLEAN,
    rol VARCHAR(50)
);
-- Tabla Empresa
CREATE TABLE Empresa (
    id_empresa INT PRIMARY KEY AUTO_INCREMENT,
    nombres VARCHAR(100),
    sucursal VARCHAR(100),
    ruc VARCHAR(11),
    direccion TEXT
);

-- Tabla Vendedor
CREATE TABLE Vendedor (
    id_vendedor INT PRIMARY KEY AUTO_INCREMENT,
    nombres VARCHAR(100),
    apellidos VARCHAR(100),
    dni VARCHAR(8),
    telefono VARCHAR(15),
    correo VARCHAR(100),
    estado BOOLEAN default 1,
    id_empresa INT,
    id_usuario INT,
    FOREIGN KEY (id_empresa) REFERENCES Empresa(id_empresa),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

-- Tabla Descuento
CREATE TABLE Descuento (
    id_descuento INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    total DECIMAL(10, 2)
);

-- Tabla Venta
CREATE TABLE Venta (
    id_venta INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    id_vendedor INT,
    id_descuento INT,
    total DECIMAL(10, 2),
    fechaVenta DATE,
    vigente BOOLEAN,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_vendedor) REFERENCES Vendedor(id_vendedor),
    FOREIGN KEY (id_descuento) REFERENCES Descuento(id_descuento)
);

-- Tabla DetalleVenta
CREATE TABLE DetalleVenta (
    id_detalleVenta INT PRIMARY KEY AUTO_INCREMENT,
    id_venta INT,
    id_medicamento INT,
    cantidadVendida INT,
    precioMedicamento DECIMAL(10, 2),
    TotalVendido DECIMAL(10, 2),
    FOREIGN KEY (id_venta) REFERENCES Venta(id_venta),
    FOREIGN KEY (id_medicamento) REFERENCES Medicamento(id_medicamento)
);

-- Tabla Devolucion
CREATE TABLE Devolucion (
    id_devolucion INT PRIMARY KEY AUTO_INCREMENT,
    id_venta INT,
    motivo TEXT,
    fechaReclamo DATE,
    vigente BOOLEAN,
    FOREIGN KEY (id_venta) REFERENCES Venta(id_venta)
);

-- Inserción de Datos 
INSERT INTO Proveedor (nombre, contacto, telefono) VALUES
('Laboratorio Johnson', 'Juan Pérez', '123456789'),
('Farmaceutica del Pacifico', 'Ana Torres', '987654321');

INSERT INTO TipoMedicamento (nombre, descripcion) VALUES
('Antibiotico', 'Medicamento utilizado para tratar infecciones bacterianas'),
('Analgesico', 'Medicamento para aliviar el dolor');

INSERT INTO Medicamento (nombre, descripcion, precio, stock, fechaVencimiento, id_tipo) VALUES
('Amoxicilina', 'Antibiótico de amplio espectro', 10.50, 100, '2025-12-31', 1),
('Paracetamol', 'Alivia el dolor y reduce la fiebre', 4.00, 200, '2025-06-30', 2);

INSERT INTO Compra (id_proveedor, total, fechaCompra, vigente) VALUES
(1, 250.00, '2024-10-10', TRUE),
(2, 500.00, '2024-10-15', TRUE);

INSERT INTO detalleCompra (id_compra, id_medicamento, stock, precioUnitario) VALUES
(1, 1, 50, 10.50),
(2, 2, 70, 4.00);

INSERT INTO Cliente (nombres, apellidos, dni, direccion, telefono) VALUES
('Carlos', 'López', '12345678', 'Calle A 123', '5551234'),
('María', 'González', '87654321', 'Avenida Siempreviva 321', '5555678');

INSERT INTO Usuario (nombres, apellidos, dni, telefono, correo, clave, estado, rol) VALUES
('Fabricio', 'Reque', '12312312', '555112232', 'fabricio@gmail.com', 'clave12', 1, 'Administrador'),
('Ana', 'Rojas', '32132132', '555334478', 'ana@gmail.com', 'Ana4433', 1, 'Vendedor');

INSERT INTO Empresa (nombres, sucursal, ruc, direccion) VALUES
('Farmacia Central', 'Sucursal 1', '20123456789', 'Av. SanLuis 123'),
('Farmacia Central', 'Sucursal 2', '20123456789', 'Calle A');

INSERT INTO Vendedor (nombres, apellidos, dni, telefono, correo, estado, id_empresa, id_usuario) VALUES
('Fabricio', 'Reque', '12312312', '555112232', 'fabricio@gmail.com', 1, 1, 1),
('Ana', 'Rojas', '32132132', '555334478', 'ana@gmail.com', 1, 2, 2);

INSERT INTO Descuento (nombre, total) VALUES
('Descuento 10%', 10.00),
('Descuento 20%', 20.00);

INSERT INTO Venta (id_cliente, id_vendedor, id_descuento, total, fechaVenta, vigente) VALUES
(1, 1, 1, 1125.00, '2024-03-20', TRUE),
(2, 2, 2, 400.00, '2024-04-15', TRUE);

INSERT INTO DetalleVenta (id_venta, id_medicamento, cantidadVendida, precioMedicamento, TotalVendido) VALUES
(1, 1, 20, 12.50, 250.00),
(2, 2, 50, 5.00, 250.00);

INSERT INTO Devolucion (id_venta, motivo, fechaReclamo, vigente) VALUES
(1, 'Producto en mal estado', '2024-03-22', TRUE);
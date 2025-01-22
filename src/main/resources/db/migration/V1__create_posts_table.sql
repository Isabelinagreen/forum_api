CREATE TABLE IF NOT EXISTS posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('activo', 'inactivo') DEFAULT 'activo',
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL,
    UNIQUE(titulo, mensaje)
);

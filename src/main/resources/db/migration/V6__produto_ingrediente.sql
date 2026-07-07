CREATE TABLE produto_ingrediente(
    pin_id INT PRIMARY KEY AUTO_INCREMENT,
    pro_id INT NOT NULL,
    ing_id INT NOT NULL,
    pin_quantidade DECIMAL(10,3) NOT NULL,
    pin_unidade VARCHAR(20),
    pin_dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(pro_id) REFERENCES produto(pro_id),
    FOREIGN KEY(ing_id) REFERENCES ingrediente(ing_id),
    UNIQUE(pro_id, ing_id)
);
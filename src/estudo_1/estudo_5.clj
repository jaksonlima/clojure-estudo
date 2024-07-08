(ns estudo-1.estudo-5)

(conj ["jakson"] "lima")

(pop ["jakson" "lima"])

(defn desistir-compra
 [compras]
 (pop compras))

(defn filtra-compra
 [nome compras]
 (filter (fn [produto] (= produto nome)) compras))

(defn filtra-compra-2
 [nome compras]
 (filter #(= nome %) compras))

(defn imprimir
 [nomes]
 (nomes 0))

(defn geted
 [nomes index]
 (get nomes index "default"))

(defn assoced
 [nomes novo]
 (assoc nomes 3 novo))
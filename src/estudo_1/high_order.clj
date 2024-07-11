(ns estudo-1.high-order)


(defn printed
  [v]
  (println v))

(defn high-order
  []
  printed)

(defn taxa-http
  []
  0.3)

(defn imposto
  [taxa-http salario]
  (if (< salario 1000)
    0
    (* salario taxa-http)))


(imposto (taxa-http) 1000)

(defn imposto
  [fn-taxa-http salario]
  (if (< salario 1000)
    0
    (* salario (fn-taxa-http))))

(imposto taxa-http 100)

(defn high-order-1
  []
  (fn [x y] (+ x y)))

(defn consulta-taxa-http
  []
  (println "http external")
  0.1)


(defn consulta-taxa-db
  []
  (println "db taxa")
  0.2)

(defn escolhe-consulta-taxa-padrao
  [ambiente]
  (if (= ambiente :test)
    consulta-taxa-db
    consulta-taxa-http))

(escolhe-consulta-taxa-padrao :test)

(def person-v3 {:name :test :age 27})


































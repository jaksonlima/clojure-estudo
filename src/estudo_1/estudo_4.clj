(ns estudo-1.estudo-4)

(defn my-even
  [value]
  (even? value))

(defn my-odd
  [value]
  (odd? value))

(defn my-neg
  [value]
  (neg? value))

(defn insento-importo?
  [value]
  (< value 1000))

(defn my-if
  [value]
  (if (< value 100)
    1
    0))

(defn imposto
  [salario]
  (let [imposto-primeira-faixa 0
        imposto-segunda-faixa 0.1
        imposto-terceira-faixa 0.2]
    (if (< salario 1000)
      (* salario imposto-primeira-faixa)
      (if (< salario 2000)
        (* salario imposto-segunda-faixa)
        (* salario imposto-terceira-faixa)))))

(defn imposto?
  [salario]
  (let [total (imposto salario)
        insento 0]
    (not= total insento)))

(defn my-when
  [idade]
  (when (>= idade 18)
    (println "maior de 18")
    (println "menor de 18")
    (println "indiferente")
    ))


(println (neg? (count [])))
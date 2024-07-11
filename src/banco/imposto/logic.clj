(ns banco.imposto.logic)

(defn- esta-na-faixa-isencao?
  [valor]
  (< valor 1000))

(defn imposto-retido-font
  [imposto]
  (println "executou!!")
  (if (esta-na-faixa-isencao? imposto)
    0
    (* imposto 0.1)))


(ns estudo-1.imc)

(defn- imc-calc
  [weight height]
  (->> (* height height)
       (/ weight)))

(defn imc-indicator
  [weight height]
  (let [imc (imc-calc weight height)]
    (cond
      (< imc 18.5) :low
      (< imc 24.9) :idea
      :else :high)))

(imc-calc 90 1.58)
(imc-indicator 1 1)

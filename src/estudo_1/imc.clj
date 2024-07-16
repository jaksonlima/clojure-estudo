(ns estudo-1.imc)

(defn imc
  [weight height]
  (->> (* height height)
       (/ weight)))

(defn imc
  [weight height]
  :low)

(imc 90 1.58)
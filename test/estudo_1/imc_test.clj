(ns estudo-1.imc-test
  (:require [clojure.test :refer :all])
  (:require [estudo-1.imc :refer [imc]]))

:low
:high
:ideal

(deftest givenValidParams-WhenCallsImc-ThenValidInstance
  (testing "weight person imc low"
    (is (= :low (imc 1 2)))))



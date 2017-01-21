(ns macchiato.test.runner
  (:require
    [doo.runner :refer-macros [doo-tests]]
    [macchiato.test.crypto.core-test]))

(doo-tests 'macchiato.test.crypto.core-test)

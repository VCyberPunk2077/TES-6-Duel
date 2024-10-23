interface functionOfKnight {
    fun damageReflection(damage:Int, human:Human):Int {
        var protection: Int = 0
        if (human is Knight) {
            if (human.defense > 0) {
                if ((1..100).random() < 10) {
                    protection = human.defense
                    if (damage < protection) {
                        protection = damage
                        human.defense -= damage
                    } else
                        human.defense -= protection
                } else if ((1..100).random() < 30) {
                    protection = human.defense / 2
                    if (damage < protection) {
                        protection = damage
                        human.defense -= damage
                    } else
                        human.defense -= protection
                }
            }else
                println("Восстановите броню")
        }
        return protection
    }
}
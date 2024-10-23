class Robot(health:Int,
            power:Int,
            var battery:Int
):Human(health, power),functionOfKnight {

    override fun attack(human1: Human, human2: Human): String {
        var damage:Int = 0
        if (human1 is Robot) {
            if (human1.battery >= 70) {
                human1.battery -= 5
                damage = human1.power
            } else if ((30 < human1.battery) and (human1.battery < 70)) {
                human1.battery -= 5
                damage = (human1.power / 2)
            } else if ((5 < human1.battery) and (human1.battery <= 30)) {
                human1.battery -= 5
                damage = (human1.power / 3)
            }else{
                println("Роботу нужна подзарядка")
            }
        }
        if (human2 is Knight){
            damage = damage - damageReflection(damage,human2)
        }
        human2.health -= damage
        return "${human1} Нанёс ${damage} урон ${human2}"
    }

    override fun heal(human: Human): String {
        var hp:Int = 0
        if (human is Robot) {
            if (human.battery >= 70) {
                human.battery -= 5
                hp = (20..30).random()
                human.health += hp
            }else if ((30 < human.battery) and (human.battery < 70)) {
                human.battery -= 5
                hp = (10..20).random()
                human.health += hp
            }else if((5 <= human.battery) and (human.battery <= 30)){
                human.battery -= 5
                hp = (1..10).random()
                human.health += hp
            }}else
            println("Необходимо подзарядить робота")
        return "${human} восстановил ${hp} хп"
    }

    fun recharging(human:Human):String {
        var recharge: Int = 0
        if (human is Robot) {
            if (((1..100).random()) <= 15) {
                recharge = (20..30).random()
                human.battery += recharge
            }else if(((1..100).random()) <= 40){
                recharge = (10..20).random()
                human.battery += recharge
            }else if(((1..100).random()) <= 75) {
                recharge = (1..10).random()
                human.battery += recharge
            }else
                println("Не удалось восстановить заряд")
        }
        return "${human} восстановил ${recharge} заряда"
    }


    override fun toString(): String {
        return "Robot(health=$health,power=$power,battery=$battery)"
    }
}
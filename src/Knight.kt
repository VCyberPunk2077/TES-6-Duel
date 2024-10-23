class Knight(health:Int,
             power:Int,
             var defense:Int
):Human(health, power) {

    override fun attack(human1: Human, human2: Human): String {
        var damage:Int = 0
        if (human1 is Knight) {
            if (((1..100).random()) <= 15) {
                damage = (15..20).random() + human1.power
                human2.health -= damage
            }else if(((1..100).random()) <= 30){
                damage = (10..15).random() + human1.power
                human2.health -= damage
            }else if(((1..100).random()) <= 70) {
                damage = (5..10).random() + human1.power
                human2.health -= damage
            }else{
                damage = human1.power
                human2.health -= damage
            }}
        return "${human1} Нанёс ${damage} урон ${human2}"
    }

    override fun heal(human: Human): String {
        var hp:Int = 0
        if (human is Knight) {
            if (((1..100).random()) <= 10) {
                hp = (15..20).random()
                human.health += hp
            }else if(((1..100).random()) <= 30){
                hp = (10..15).random()
                human.health += hp
            }else if(((1..100).random()) <= 70) {
                hp = (1..10).random()
                human.health += hp
            }else{
                println("Не удалось восстановить хп")
            }}
        return "${human} восстановил ${hp} хп"
    }

    fun armorRecovery(human:Human):String {
        var recharge: Int = 0
        if (human is Knight) {
            if (((1..100).random()) <= 15) {
                recharge = (10..15).random()
                human.defense += recharge
            }else if(((1..100).random()) <= 40){
                recharge = (5..10).random()
                human.defense += recharge
            }else if(((1..100).random() <= 75)) {
                recharge = (1..5).random()
                human.defense += recharge
            }else
                println("Не удалось восстановить броню")
        }
        return "${human} восстановил ${recharge} брони"
    }

    override fun toString(): String {
        return "Knight(health=$health,power=$power,defense=$defense)"
    }
}
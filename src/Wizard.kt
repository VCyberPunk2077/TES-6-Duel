class Wizard(health:Int,
             power:Int,
             var mana:Int
) :Human(health, power),functionOfKnight {

    override fun attack(human1: Human, human2: Human): String {
        var damage:Int = 0
        if (human1 is Wizard) {
            if (human1.mana >= 5) {
                if (((1..100).random()) < 30) {
                    human1.mana -= 5
                    damage = human1.power + (10..20).random()
                } else{
                    damage = human1.power
                }}else{
                damage = human1.power
            }}
        if (human2 is Knight){
            damage = damage - damageReflection(damage,human2)
        }
        human2.health -= damage
        return "${human1} Нанёс ${damage} урон ${human2}"
    }

    override fun heal(human: Human): String {
        var hp:Int = 0
        if (human is Wizard) {
            if (human.mana >= 5) {
                if (((1..100).random()) <= 70) {
                    human.mana -= 5
                    hp = (10..20).random()
                    human.health += hp
                } else{
                    hp = 0
                    human.health += hp
                }} else if (((1..100).random()) <= 20) {
                hp = (1..10).random()
                human.health += hp
            } else{
                hp = 0
                human.health += hp
                println("Необходимо восстановить ману")
            }}
        return "${human} восстановил ${hp} хп"
    }

    fun manaRecovery(human:Human):String {
        var recharge: Int = 0
        if (human is Wizard) {
            if (((1..100).random()) <= 15) {
                recharge = (20..30).random()
                human.mana += recharge
            }else if(((1..100).random()) <= 40){
                recharge = (10..20).random()
                human.mana += recharge
            }else if(((1..100).random()) <= 75) {
                recharge = (1..10).random()
                human.mana += recharge
            }else
                println("Не удалось восстановить ману")
        }
        return "${human} восстановил ${recharge} маны"
    }
    override fun toString(): String {
        return "Wizard(health=$health,power=$power,mana=$mana)"
    }

}
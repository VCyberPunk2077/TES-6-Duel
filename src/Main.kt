import java.util.*

fun main() {
    var input = Scanner(System.`in`)
    println("Start GAME")
    println("Введите здоровье, силу и ману мага")
    var wizard = Wizard(input.nextInt(), input.nextInt(), input.nextInt())
    println("Введите здоровье, силу и заряд робота")
    var robot = Robot(input.nextInt(), input.nextInt(), input.nextInt())
    println("Введите здоровье, силу и показатели брони рыцаря")
    var knight = Knight(input.nextInt(), input.nextInt(), input.nextInt())

    println("Стартовые характеристики героев:")
    println(wizard)
    println(robot)
    println(knight)

    while ((wizard.health > 0) and (robot.health > 0) and (knight.health > 0)) {
        var game: Int = 0
        var human1: String
        var action: String
        var human2: String
        println("Введите номер песонажа, который выполняет действие(1.wizard, 2.robot, 3.knight)")
        human1 = readLine().toString()
        when (human1) {
            "1" -> {
                println(
                    "Выберите номер действие:" +
                            "1.attack" +
                            "2.heal" +
                            "3.manaRecovery"
                )
                action = readLine().toString()
                when (action) {
                    "1" -> {
                        println("Введите номер персонажа, которого атакуете(1.robot, 2.knight)")
                        human2 = readLine().toString()
                        when (human2) {
                            "1" -> {
                                println(wizard.attack(wizard, robot))
                            }

                            "2" -> {
                                println(wizard.attack(wizard, knight))
                            }
                        }
                    }

                    "2" -> {
                        println(wizard.heal(wizard))
                    }

                    "3" -> {
                        println(wizard.manaRecovery(wizard))
                    }
                }
            }

            "2" -> {
                println(
                    "Выберите номер действие:" +
                            "1.attack" +
                            "2.heal" +
                            "3.recharging"
                )
                action = readLine().toString()
                when (action) {
                    "1" -> {
                        println("Введите номер персонажа, которого атакуете(1.wizard, 2.knight)")
                        human2 = readLine().toString()
                        when (human2) {
                            "1" -> {
                                println(robot.attack(robot, wizard))
                            }

                            "2" -> {
                                println(robot.attack(robot, knight))
                            }
                        }
                    }

                    "2" -> {
                        println(robot.heal(robot))
                    }

                    "3" -> {
                        println(robot.recharging(robot))
                    }
                }
            }

            "3" -> {
                println(
                    "Выберите номер действие:" +
                            "1.attack" +
                            "2.heal" +
                            "3.armorRecovery"
                )
                action = readLine().toString()
                when (action) {
                    "1" -> {
                        println("Введите номер персонажа, которого атакуете(1.wizard, 2.robot)")
                        human2 = readLine().toString()
                        when (human2) {
                            "1" -> {
                                println(knight.attack(knight, wizard))
                            }

                            "2" -> {
                                println(knight.attack(knight, robot))
                            }
                        }
                    }

                    "2" -> {
                        println(knight.heal(knight))
                    }

                    "3" -> {
                        println(knight.armorRecovery(knight))
                    }
                }
            }
        }
        println()
        println("Итоги после раунда:")
        println(wizard)
        println(robot)
        println(knight)
        println()
        if ((wizard.health > 0) and (robot.health > 0) and (knight.health > 0)) {
            println("Хотите продолжить игру дальше?(1 - да, 0 - нет)")
            game = readLine()!!.toInt()
            if (game == 0)
                break
        } else
            println("Здоровье одного из персонажей <= 0")
    }
    println()
    println("The END")
    println("Итоговый рейтинг персонажей:")
    var customComporator = comparator()
    val arrayHuman = arrayOf(wizard,robot,knight)
    Arrays.sort(arrayHuman,customComporator)
    println(arrayHuman.contentToString())
}
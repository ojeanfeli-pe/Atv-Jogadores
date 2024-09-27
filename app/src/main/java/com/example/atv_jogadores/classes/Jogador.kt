package com.example.atv_jogadores.classes

class Jogador(
    var nome: String,
    var level: Int = 1,
    var bonusEquipamento: Int = 0,
    var modificadores: Int = 0
) {
    val poderTotal: Int
        get() = level + bonusEquipamento + modificadores
}
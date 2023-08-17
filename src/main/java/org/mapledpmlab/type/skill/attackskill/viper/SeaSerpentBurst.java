package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SeaSerpentBurst extends AttackSkill {
    public SeaSerpentBurst() {
        this.setName("씨 서펜트 버스트");
        this.setAttackCount(8L);
        this.setDamage(430.0);
        this.setCooldown(7.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}

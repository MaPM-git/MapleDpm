package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.viper.SeaSerpentEnrageBuff;

public class SeaSerpentEnrage extends AttackSkill {
    public SeaSerpentEnrage() {
        this.setName("씨 서펜트 인레이지");
        this.setAttackCount(6L);
        this.setDamage(870.0);
        this.setCooldown(4.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new SeaSerpentEnrageBuff());
    }
}

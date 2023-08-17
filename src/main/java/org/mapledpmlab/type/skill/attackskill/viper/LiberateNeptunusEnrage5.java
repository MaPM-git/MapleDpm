package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LiberateNeptunusEnrage5 extends AttackSkill {
    public LiberateNeptunusEnrage5() {
        this.setName("리버레이트 넵투누스(넵투누스 인레이지 5타)");
        this.setAttackCount(12L);
        this.setCooldown(4.0);
        this.setDamage(3600.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}

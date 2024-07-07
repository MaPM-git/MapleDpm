package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LiberateNeptunusEnrage1 extends AttackSkill {
    public LiberateNeptunusEnrage1() {
        this.setName("리버레이트 넵투누스(넵투누스 인레이지 1타)");
        this.setAttackCount(12L);
        this.setCooldown(4.0);
        this.setDamage(1680.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.setRelatedSkill(new LiberateNeptunusEnrage2());
    }
}

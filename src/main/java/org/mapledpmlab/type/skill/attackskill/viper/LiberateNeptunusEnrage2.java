package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LiberateNeptunusEnrage2 extends AttackSkill {
    public LiberateNeptunusEnrage2() {
        this.setName("리버레이트 넵투누스(넵투누스 인레이지 2타)");
        this.setAttackCount(8L);
        this.setCooldown(4.0);
        this.setDamage(2400.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new LiberateNeptunusEnrage3());
    }
}

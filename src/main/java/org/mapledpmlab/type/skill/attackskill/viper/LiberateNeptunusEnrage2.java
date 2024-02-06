package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LiberateNeptunusEnrage2 extends AttackSkill {
    public LiberateNeptunusEnrage2() {
        this.setName("리버레이트 넵투누스(넵투누스 인레이지 2타)");
        this.setAttackCount(13L);
        this.setDamage(1800.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new LiberateNeptunusEnrage3());
        this.getMultiAttackInfo().add(540L);
    }
}

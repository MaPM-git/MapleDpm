package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LiberateNeptunusEnrage3 extends AttackSkill {
    public LiberateNeptunusEnrage3() {
        this.setName("리버레이트 넵투누스(넵투누스 인레이지 3타)");
        this.setAttackCount(15L);
        this.setDamage(1920.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new LiberateNeptunusEnrage4());
        this.getMultiAttackInfo().add(840L);
    }
}

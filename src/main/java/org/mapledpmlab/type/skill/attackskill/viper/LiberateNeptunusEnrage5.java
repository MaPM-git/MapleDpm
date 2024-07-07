package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LiberateNeptunusEnrage5 extends AttackSkill {
    public LiberateNeptunusEnrage5() {
        this.setName("리버레이트 넵투누스(넵투누스 인레이지 5타)");
        this.setAttackCount(15L);
        this.setDamage(2180.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.getMultiAttackInfo().add(1860L);
    }
}

package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

import java.util.ArrayList;

public class MesoExplosion extends AttackSkill {
    public MesoExplosion() {
        this.setName("메소 익스플로젼");
        this.setAttackCount(2L);
        this.setDamage(300.0);
        this.setAddDamage(40 + 20L);    // 메소 익스플로젼-리인포스
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(500L);
    }
}

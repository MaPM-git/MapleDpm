package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChainArtsStroke1 extends AttackSkill {
    public ChainArtsStroke1() {
        this.setName("체인아츠:스트로크(1타)");
        this.setDamage(300.0);
        this.setAttackCount(2L);
        this.setDelayByAttackSpeed(330L);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);             // 체인아츠:스트로크-리인포스
    }
}

package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChainArtsStroke2 extends AttackSkill {
    public ChainArtsStroke2() {
        this.setName("체인아츠:스트로크(2타)");
        this.setDamage(560.0);
        this.setAttackCount(5L);
        this.setDelay(150L + 30);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);             // 체인아츠:스트로크-리인포스
    }
}

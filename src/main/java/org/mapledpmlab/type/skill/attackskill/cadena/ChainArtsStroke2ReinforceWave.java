package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChainArtsStroke2ReinforceWave extends AttackSkill {
    public ChainArtsStroke2ReinforceWave() {
        this.setName("체인아츠:스트로크(강화 2타, 충격파)");
        this.setDamage(990.0);
        this.setAttackCount(10L);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);             // 체인아츠:스트로크-리인포스
    }
}

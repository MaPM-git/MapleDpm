package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.shadower.HeartbreakerDarksight;

public class HeartbreakerCancleStack extends AttackSkill {
    public HeartbreakerCancleStack() {
        this.setName("분쇄(충전, 노쿨)");
        this.setAttackCount(6L * 2);
        this.setDamage(480.0);
        this.setDelay(480L);
        this.setAddDamage(20L);         // 블래스트-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        //this.setRelatedSkill(new HeartbreakerDarksight());
    }
}

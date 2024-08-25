package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.shadower.HeartbreakerDarksight;

public class HeartbreakerFinishCancle extends AttackSkill {
    public HeartbreakerFinishCancle() {
        this.setName("분쇄(마무리 일격)");
        this.setAttackCount(6L);
        this.setDamage(835.0);
        this.setDelayByAttackSpeed(540L);
        //this.setDelayByAttackSpeed(360L);
        this.addFinalDamage(1.5);
        this.setAddDamage(20L);         // 블래스트-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.7);       // 쉐도우 파트너
        //this.setRelatedSkill(new HeartbreakerDarksight());
    }
}

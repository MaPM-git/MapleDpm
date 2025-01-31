package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.shadower.HeartbreakerDarksight;

public class HeartbreakerFinish extends AttackSkill {
    public HeartbreakerFinish() {
        this.setName("분쇄(마무리 일격)");
        this.setAttackCount(6L * 2);
        this.setDamage(835.0 + 100);
        //this.setDelayByAttackSpeed(540L);
        this.setDelay(270L);
        this.setCooldown(10.0);
        this.addFinalDamage(1.5);
        this.setAddDamage(20L);         // 블래스트-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        //this.setRelatedSkill(new HeartbreakerDarksight());
    }
}

package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RobotTransitionCBP1 extends AttackSkill {
    public RobotTransitionCBP1() {
        this.setName("로봇 트랜지션 : CB-P1");
        this.setAttackCount(8L);
        this.setDamage(1230.0);
        this.setInterval(2000L);
        this.setDotDuration(660000L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}

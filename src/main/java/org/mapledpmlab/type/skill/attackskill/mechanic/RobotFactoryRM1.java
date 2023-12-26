package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RobotFactoryRM1 extends AttackSkill {
    public RobotFactoryRM1() {
        this.setName("로봇 팩토리 : RM1");
        this.setAttackCount(3L);
        this.setDamage(1000.0);
        this.setInterval(3000L);
        this.setDotDuration((long) (70000L * 1.42));
        this.addFinalDamage(2.11);              // 로봇 마스터리
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}

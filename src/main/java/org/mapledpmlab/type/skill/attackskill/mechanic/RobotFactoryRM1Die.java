package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RobotFactoryRM1Die extends AttackSkill {
    public RobotFactoryRM1Die() {
        this.setName("로봇 팩토리 : RM1(자폭)");
        this.setAttackCount(1L);
        this.setDamage(1010.0);
        this.addFinalDamage(2.01);              // 로봇 마스터리
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new RobotFactoryRM1Summon());
    }
}

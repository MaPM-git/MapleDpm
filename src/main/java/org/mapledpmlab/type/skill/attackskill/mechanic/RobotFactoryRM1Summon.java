package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RobotFactoryRM1Summon extends AttackSkill {
    public RobotFactoryRM1Summon() {
        this.setName("로봇 팩토리 : RM1");
        this.setDelay(630L);
        this.setRelatedSkill(new RobotFactoryRM1());
    }
}

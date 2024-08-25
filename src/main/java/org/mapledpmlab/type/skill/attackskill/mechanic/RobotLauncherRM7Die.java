package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RobotLauncherRM7Die extends AttackSkill {
    public RobotLauncherRM7Die() {
        this.setName("로봇 런처 : RM7(자폭)");
        this.setAttackCount(1L);
        this.setDamage(400.0 + 143);
        this.addFinalDamage(2.11);              // 로봇 마스터리
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new RobotLauncherRM7Summon());
    }
}

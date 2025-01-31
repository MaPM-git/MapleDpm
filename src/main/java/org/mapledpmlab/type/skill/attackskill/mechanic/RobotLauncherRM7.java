package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RobotLauncherRM7 extends AttackSkill {
    public RobotLauncherRM7() {
        this.setName("로봇 런처 : RM7");
        this.setAttackCount(3L);
        this.setDamage(605.0);
        this.setInterval(1000L);
        this.setDotDuration(98000L);
        //this.addFinalDamage(2.11);              // 로봇 마스터리
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}

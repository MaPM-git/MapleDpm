package org.mapledpmlab.type.skill.attackskill.zero;

public class JumpingCrashShockWave extends AssistSkill implements BetaSkill {
    public JumpingCrashShockWave() {
        this.setName("점핑 크래시(충격파)");
        this.setAttackCount(3L);
        this.setDamage(320.0 + 60);
        this.setDelay(30L);
        this.setAssistDelay(30L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        //this.getMultiAttackInfo().add(270L);
    }
}

package org.mapledpmlab.type.skill.attackskill.zero;

public class JumpingCrashShockWave extends AssistSkill implements BetaSkill {
    public JumpingCrashShockWave() {
        this.setName("점핑 크래시(충격파)");
        this.setAttackCount(3L);
        this.setDamage(360.0 + 30);
        //this.setDelayByAttackSpeed(270L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        //this.getMultiAttackInfo().add(270L);
    }
}

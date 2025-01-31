package org.mapledpmlab.type.skill.attackskill.zero;

public class JumpingCrash extends AssistSkill implements BetaSkill {
    public JumpingCrash() {
        this.setName("점핑 크래시");
        this.setAttackCount(6L);
        this.setDamage(360.0 + 60);
        //this.setDelayByAttackSpeed(660L);
        this.setDelay(450L);
        this.setAssistDelay(510L);
        this.setRelatedSkill(new JumpingCrashShockWave());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}

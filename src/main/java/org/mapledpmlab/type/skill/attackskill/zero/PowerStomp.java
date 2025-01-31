package org.mapledpmlab.type.skill.attackskill.zero;

public class PowerStomp extends AssistSkill implements BetaSkill {
    public PowerStomp() {
        this.setName("파워 스텀프");
        this.setAttackCount(9L);
        this.setDamage(432.0);
        //this.setDelayByAttackSpeed(750L);
        this.setDelay(540L);
        this.setRelatedSkill(new PowerStompShockWave());
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAssistDelay(540L);
    }
}

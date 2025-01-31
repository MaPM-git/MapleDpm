package org.mapledpmlab.type.skill.attackskill.zero;

public class PowerStompShockWave extends AssistSkill implements BetaSkill {
    public PowerStompShockWave() {
        this.setName("파워 스텀프(충격파)");
        this.setAttackCount(9L);
        this.setDamage(432.0);
        this.setDelayByAttackSpeed(30L);
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        //this.getMultiAttackInfo().add(960L);
        this.setAssistDelay(30L);
    }
}

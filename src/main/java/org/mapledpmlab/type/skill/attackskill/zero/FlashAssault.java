package org.mapledpmlab.type.skill.attackskill.zero;

public class FlashAssault extends AssistSkill implements AlphaSkill {
    public FlashAssault() {
        this.setName("플래시 어썰터");
        this.setAttackCount(5L);
        this.setDamage(250.0);
        this.setDelay(270L);
        this.setAssistDelay(270L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setMove(true);
        this.setGaugeCharge(-9.0);
    }
}

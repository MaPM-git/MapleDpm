package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalBlowAdrenaline extends AttackSkill {
    public FinalBlowAdrenaline() {
        this.setName("파이널 블로우(아드레날린)");
        this.setDamage(285.0 + 5 + 21 + 100 + 150 + 62);
        this.setAttackCount(7L);
        this.setDelay(420L);
        this.addIgnoreDefenseList(15L);
        this.setRelatedSkill(new FinalBlowWave());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}

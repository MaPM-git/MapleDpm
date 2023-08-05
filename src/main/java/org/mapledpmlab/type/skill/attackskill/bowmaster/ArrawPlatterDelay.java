package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ArrawPlatterDelay extends AttackSkill {
    public ArrawPlatterDelay() {
        this.setName("애로우 플래터");
        this.setDelayByAttackSpeed(600L);
        this.setCooldown(60.0);
        // 애로우 레인, 퀴버 카트리지, 모탈 블로우, 파이널 어택 등 미적용
    }
}

package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.NormalFarm;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class BattleMage extends Job {

    public BattleMage() {
        // 기본
        super();
        this.setName("배틀메이지");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.ETC);
        this.addObject(new BossCriticalAbnormal());
        this.addObject(new NormalFarm());
        this.addObject(new HybridLogic());
        this.addObject(new IntUnion());
        this.addPerXMainStat(20L);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addMagic((long) (406 + 250 + 72 + 276));
        this.setWeaponAttMagic((long) (406 + 250 + 72 + 276));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);
        this.addMagicP(3L);

        // 보조
        this.addMainStat((long) (10 + 80 + 75));
        this.addSubStat(75L);
        this.addAtt(45L);
        this.addMagic((long) (1 + 45));
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);

        // 1차
        this.addMagic(20L);             // 아트 오브 스태프
        this.addCriticalP(15.0);

        // 2차
        this.addMagic(30L);             // 스태프 마스터리
        this.addCriticalP(20.0);
        this.addMainStat(40L);          // 하이 위즈덤

        // 3차
        this.addFinalDamage(1.25);      // 배틀 마스터리
        this.addCriticalDamage(15.0);

        // 4차
        this.addMagicP(15L);            // 다크 오라
        this.addDamage(10L);
        this.addBossDamage(5L);
        this.addDamage(25L);            // 배틀 레이지
        this.addCriticalP(21.0);
        this.addCriticalDamage(10.0);
        this.addMagic(31L);             // 스태프 엑스퍼트
        this.addCriticalDamage(21.0);
        this.addFinalDamage(1.05);      // 스펠 부스트
        this.addMagicP(10L);
        this.addDamage(11L);
        this.addIgnoreDefenseList(31L);

        this.setAbility(new BossCriticalAbnormal());
        this.setFarm(new NormalFarm());
        this.getLinkList().add(new HybridLogic());
        this.setUnion(new IntUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getFarm());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();
        this.addFinalDamage(1.08);          // 오버로드 마나
        this.addIgnoreDefenseList(20L);     // 디버프 오라
        this.addProperty(10L);
        this.addFinalDamage(1.08);
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                        * Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}

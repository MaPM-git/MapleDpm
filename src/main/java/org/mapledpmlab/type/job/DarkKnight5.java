package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalReuse;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class DarkKnight5 extends Job {

    public DarkKnight5() {
        // 기본
        super();
        this.setName("다크나이트(5초, 리레단일)");
        this.setConstant(1.49);         // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(2815680.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (340 + 210 + 72 + 253));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (340 + 210 + 72 + 253));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addAtt(3L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("웨폰 마스터리");
        passive.addDamage(5L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("웨폰 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("크로스 오버 체인");
        passive.addFinalDamage(1.8);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("비홀더스 버프");
        passive.addAtt(70L);
        passive.addMagic(70L);
        passive.addCriticalP(10.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("로드 오브 다크니스");
        passive.addCriticalP(30.0);
        passive.addCriticalDamage(8.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("리인카네이션");
        passive.addFinalDamage(1.36);
        passive.addCriticalP(11.0);
        passive.addCriticalDamage(15.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("다크 레조넌스");
        passive.addFinalDamage(1.08);
        passive.addIgnoreDefenseList(11L);
        passive.addBossDamage(16L);
        passive.addIgnoreDefenseList(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드팬스드 웨폰 마스터리");
        passive.addAtt(31L);
        passive.addCriticalDamage(15.0);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("바디 오브 스틸");
        passive.addMainStat(30L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-87L);
        this.addMainStat(2L);
        this.addSubStat(-5L);

        this.setAbility(new BossAbnormalReuse());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.setUnion(new StrUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("리인카네이션(콜렉터의 영약)");
        doping.minusFinalDamage(1.36);
        doping.addFinalDamage(1.37);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("어드팬스드 웨폰 마스터리(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
